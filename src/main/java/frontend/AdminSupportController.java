/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the controller class for the admin support page. All the functions
 (adding a profile and accessing the page) are defined here. The page is also locked to users
 who have not logged in using the user session controller and client users.
 ***************************************************************************************************/


package frontend;

import comp3095_mayflower.demo.backend.UserServiceImpl;
import comp3095_mayflower.demo.backend.controllers.UserController;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.UserRepository;
import comp3095_mayflower.demo.backend.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AdminSupportController {

    @Qualifier
    private UserServiceImpl userServiceImpl;
    UserRepository userRepository;
    private UserController userController;
    private UserService userService;

    public AdminSupportController(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @GetMapping("/supportadmin")
    public ModelAndView showAdminSupportPage(Model model){
        User user = UserSessionController.loggedInUser;
        if(user==null||user.getRole().equals("user")) {
            return new ModelAndView("login");
        }
        model.addAttribute("adminusers",userRepository.findByRole("admin"));
        return new ModelAndView("supportadmin");

    }



    @RequestMapping(value="/supportadmin",method= RequestMethod.POST)
        public ModelAndView addAdminUser(@RequestParam(value="firstname")String firstname,
        @RequestParam(value="lastname")String lastname,
        @RequestParam(value="address")String address,
        @RequestParam(value="email")String email,
        @RequestParam(value="password")String password) {

        User user = new User(firstname, lastname, address, email, password, "admin");
        userRepository.save(user);
        return new ModelAndView(new RedirectView("supportadmin"));

    }
}


