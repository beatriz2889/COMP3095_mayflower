/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the controller class for the credit profile page. All the functions
 (adding a profile, updating a profile, deleting a profile and accessing the page are defined
 here. The page is also locked to users who have not logged in using the user session controller.
 ***************************************************************************************************/

package frontend;

import comp3095_mayflower.demo.backend.CreditServiceImpl;
import comp3095_mayflower.demo.backend.entities.CreditProfile;
import comp3095_mayflower.demo.backend.controllers.CreditProfileBackendController;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.CreditProfileRepository;
import comp3095_mayflower.demo.backend.services.CreditService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class CreditProfileFrontendController {

    @Qualifier
    private CreditServiceImpl creditServiceImpl;
    CreditService creditService;
    CreditProfileRepository creditProfileRepository;
    private CreditProfileBackendController creditProfileBackendController;
    private static final Logger log= LoggerFactory.getLogger(CreditProfileFrontendController.class);

    @Autowired
    public CreditProfileFrontendController(CreditProfileRepository creditProfileRepository){this.creditProfileRepository=creditProfileRepository;}


    @GetMapping("/creditprofile")
    public ModelAndView showCreditProfilePage(Model model){
        User user= UserSessionController.loggedInUser;
        if(user==null) {
            return new ModelAndView("login");
        }
        model.addAttribute("creditprofiles", creditProfileRepository.findAllByUser_Id(user.getId()));
        return new ModelAndView("creditprofile");
    }

    @GetMapping("creditprofiles/delete/{creditid}")
    public ModelAndView deleteCreditProfile(@PathVariable(value="creditid")int creditid, Model model){
        User currentUser=UserSessionController.loggedInUser;
        CreditProfile creditprofile=creditProfileRepository.findById(creditid).orElseThrow(()->new IllegalArgumentException(("Invalid credit id:"+creditid)));
        creditProfileRepository.delete(creditprofile);

        model.addAttribute("creditprofiles",creditProfileRepository.findAllByUser_Id(currentUser.getId()));
        return new ModelAndView("creditprofile");
    }

    @RequestMapping(value="/creditprofile",method= RequestMethod.POST)
    public ModelAndView addCreditProfile(@RequestParam(value="cardType")String cardType,
                                         @RequestParam(value="expDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date expDate,
                                         @RequestParam(value="name")String name,
                                         @RequestParam(value="cardNum") Integer cardNum,
                                         @RequestParam(value="defaultCard", required = false)Boolean defaultCard){
        User user=UserSessionController.loggedInUser;
        if(defaultCard == null) {
            defaultCard = false;
        }

        CreditProfile cardNumExists=creditProfileRepository.findByCardnum(cardNum);

        if(cardNumExists==null) {


            CreditProfile creditProfile = new CreditProfile(cardType, expDate, name, cardNum, defaultCard, user);
            creditProfileRepository.save(creditProfile);
            return new ModelAndView(new RedirectView("creditprofile"));
        }
        else{
            CreditProfile creditProfile = new CreditProfile(cardType, expDate, name, cardNum, defaultCard, user);
            creditProfile.setCreditid(cardNumExists.getCreditid());
            creditProfileRepository.save(creditProfile);
            return new ModelAndView(new RedirectView("creditprofile"));
        }

   }
}
