/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #2 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-11-08
 * Description: This is the controller class for the login. The login function is defined here which
 takes two parameters (email and password). The function checks if the email and password match the
 email and password of a user in the database. If it does, then the user is redirected to the
 dashboard page. If not, then it stays on the login page. Mappings for the login nd registration page
 are defined as well since there is a button that links to the registration page from login.
 ***************************************************************************************************/


package frontend;

import comp3095_mayflower.demo.backend.*;
import comp3095_mayflower.demo.backend.controllers.UserController;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import java.util.Objects;

@Controller

public class LoginController {

    @Qualifier
    private UserServiceImpl userServiceImpl;
    UserRepository userRepository;
    private UserController userController;
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "email") String email,
                              @RequestParam(value = "password") String password,
                              Model model) {
        User user = userRepository.findByEmail(email);
        if (Objects.nonNull(user) && email.equals(user.getEmail())
                && password.equals(user.getPassword())&& user.getRole().equals("user")) {
            UserSessionController.loggedInUser = user;
            return new ModelAndView(new RedirectView("/dashboard", true));
        } else if (Objects.nonNull(user) && email.equals(user.getEmail())
                && password.equals(user.getPassword())&& user.getRole().equals("admin")) {
            UserSessionController.loggedInUser=user;
            return new ModelAndView(new RedirectView("/admindashboard", true));
        }else
            // To display login error message
            model.addAttribute("invalidCredentials", true);

            return new ModelAndView("login");
        }
    }




