/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the controller class for the admin profile page. All the functions
 (adding a profile, updating a profile, deleting a profile and accessing the page are defined
 here. The page is also locked to users who have not logged in using the user session controller
 and client users.
 ***************************************************************************************************/

package frontend;

import comp3095_mayflower.demo.backend.controllers.UserController;
import comp3095_mayflower.demo.backend.entities.AdminProfile;
import comp3095_mayflower.demo.backend.entities.CreditProfile;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.AdminProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class AdminProfileController {
    @Qualifier
    AdminProfileRepository adminProfileRepository;
    private UserController userController;

    @Autowired
    public AdminProfileController(AdminProfileRepository adminProfileRepository) {
        this.adminProfileRepository = adminProfileRepository;
    }

    @GetMapping("/adminprofile")
    public ModelAndView showAdminProfilePage(Model model) {
        User user = UserSessionController.loggedInUser;
        if(user==null || user.getRole().equals("user")){
            return new ModelAndView("login");

        }
        model.addAttribute("adminprofiles", adminProfileRepository.findByUser_Id(user.getId()));
        return new ModelAndView("adminprofile");
    }


    @RequestMapping(value = "/adminprofile", method = RequestMethod.POST)
    public ModelAndView addOrUpdateAdminProfile(@RequestParam(value = "firstname") String firstname,
                                        @RequestParam(value = "lastname") String lastname,
                                        @RequestParam(value = "email") String email,
                                        @RequestParam(value = "dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
                                        @RequestParam(value = "address") String address,
                                        @RequestParam(value = "city") String city,
                                        @RequestParam(value = "country") String country,
                                        @RequestParam(value = "postalcode") String postalcode) {
        User user = UserSessionController.loggedInUser;
        User currentUser=UserSessionController.loggedInUser;
        List<AdminProfile> profileExists = adminProfileRepository.findByUser_Id(currentUser.getId());

        if (profileExists.size() == 0) {

            AdminProfile adminProfile = new AdminProfile(firstname, lastname, email, dob, address, city, country, postalcode, user);
            adminProfileRepository.save(adminProfile);
            return new ModelAndView(new RedirectView("adminprofile"));
        }
        else{
            AdminProfile adminProfile = new AdminProfile(firstname, lastname, email, dob, address, city, country, postalcode, currentUser);
            adminProfile.setAdminprofileid(profileExists.get(0).getAdminprofileid());
            adminProfileRepository.save(adminProfile);
            return new ModelAndView(new RedirectView("adminprofile"));
        }



    }

    @PutMapping("/adminprofile")
    public ModelAndView updateAdminProfile(@RequestBody AdminProfile adminProfile){
        adminProfileRepository.save(adminProfile);
        return new ModelAndView(new RedirectView("adminprofile"));
    }

    }


