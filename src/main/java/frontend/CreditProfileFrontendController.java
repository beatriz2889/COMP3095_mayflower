package frontend;

import comp3095_mayflower.demo.backend.entities.CreditProfile;
import comp3095_mayflower.demo.backend.controllers.CreditProfileBackendController;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.CreditProfileRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class CreditProfileFrontendController {

    CreditProfileRepository creditProfileRepository;
    private CreditProfileBackendController creditProfileBackendController;
    private static final Logger log= LoggerFactory.getLogger(CreditProfileFrontendController.class);

    @Autowired
    public CreditProfileFrontendController(CreditProfileRepository creditProfileRepository){this.creditProfileRepository=creditProfileRepository;}

    /*
    @RequestMapping(value="/creditprofiles",method= RequestMethod.GET)
    public String creditProfileList(Model model){
        //User user=new User();
        model.addAttribute("creditprofiles",creditProfileRepository.findAll());
        return "creditprofile";
    }*/

   @RequestMapping(value="/creditprofile",method= RequestMethod.POST)
    public ModelAndView addCreditProfile(@RequestParam(value="cardType")String cardType,
                                         @RequestParam(value="expDate") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")LocalDateTime expDate,
                                         @RequestParam(value="name")String name,
                                         @RequestParam(value="cardNum") Integer cardNum,
                                         @RequestParam(value="defaultCard", required = false)Boolean defaultCard){
        User user=new User();
        if(defaultCard == null) {
            defaultCard = false;
        }
        CreditProfile creditProfile=new CreditProfile(cardType,expDate,name,cardNum,defaultCard);
        creditProfileRepository.save(creditProfile);
        return new ModelAndView("creditprofile");


   }
}
