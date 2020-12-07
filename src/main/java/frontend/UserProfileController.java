/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the controller class for the user profile page. All the functions
 (adding a profile, updating a profile, deleting a profile and accessing the page are defined
 here. The page is also locked to users who have not logged in using the user session controller.
 There is some code that checks if there is a unique first name, last name or date of birth
 in an existing profile belonging to the user. If there is, then it performs an update in the
 profile that has either the same first name, last name or date of birth since they are unique
 values.
 ***************************************************************************************************/


package frontend;


import comp3095_mayflower.demo.backend.entities.CreditProfile;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.entities.UserProfile;
import comp3095_mayflower.demo.backend.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

@Controller
public class UserProfileController {

    @Qualifier
    UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileController(UserProfileRepository userProfileRepository){
        this.userProfileRepository=userProfileRepository;
    }

    @GetMapping("/userprofile")
    public ModelAndView showUserProfilePage(Model model){
        User user=UserSessionController.loggedInUser;
        if(user==null){
            return new ModelAndView("login");
        }
        model.addAttribute("userprofiles",userProfileRepository.findAllByUser_Id(user.getId()));
        return new ModelAndView("userprofile");

    }

    @RequestMapping(value="/userprofile",method= RequestMethod.POST)
    public ModelAndView addUserProfile(@RequestParam(value="firstname")String firstname,
                                       @RequestParam(value="lastname")String lastname,
                                       @RequestParam(value="email")String email,
                                       @RequestParam(value="dob")@DateTimeFormat(pattern="yyyy-MM-dd") Date dob,
                                       @RequestParam(value="address")String address,
                                       @RequestParam(value="city")String city,
                                       @RequestParam(value="country")String country,
                                       @RequestParam(value="postalcode")String postalcode,
                                       @RequestParam(value="defaultbilling",required = false)Boolean defaultbilling,
                                       @RequestParam(value="defaultshipping",required = false)Boolean defaultshipping) {

        User user = UserSessionController.loggedInUser;
        if (defaultbilling == null) {
            defaultbilling = false;
        }
        if (defaultshipping == null) {
            defaultshipping = false;
        }


        UserProfile dobExists=userProfileRepository.findByDob(dob);
        UserProfile lastNameExists=userProfileRepository.findByLastname(lastname);
        UserProfile firstNameExists = userProfileRepository.findByFirstname(firstname);
        UserProfile userProfile = new UserProfile(firstname, lastname, email, dob, address, city, country, postalcode, defaultbilling, defaultshipping, user);
        int existingUserId;
        if(firstNameExists != null){
            existingUserId = firstNameExists.getUserprofileid();
        }
        else if(lastNameExists!=null){
            existingUserId = lastNameExists.getUserprofileid();
        }
        else if(dobExists!=null){
            existingUserId = dobExists.getUserprofileid();
        }
        else{
            userProfileRepository.save(userProfile);
            return new ModelAndView(new RedirectView("userprofile"));
        }
        userProfile.setUserprofileid(existingUserId);
        userProfileRepository.save(userProfile);
        return new ModelAndView(new RedirectView("userprofile"));
    }

    @GetMapping("userprofiles/delete/{userprofileid}")
    public String deleteUserProfile(@PathVariable(value="userprofileid")int userprofileid, Model model){
        User currentUser=UserSessionController.loggedInUser;
        UserProfile userProfile=userProfileRepository.findById(userprofileid).orElseThrow(()->new IllegalArgumentException(("Invalid user profile id:"+userprofileid)));
        userProfileRepository.delete(userProfile);
        model.addAttribute("userprofiles",userProfileRepository.findAllByUser_Id(currentUser.getId()));
        return "userprofile";
    }
}
