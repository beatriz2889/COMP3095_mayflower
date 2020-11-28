/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #2 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-11-08
 * Description: This is the controller class for the registration page. It contains the url mapping
 to the register page and the register function. The function takes the user input and creates a
 new user with the input as the parameters. The functions also checks if the password and
 confirmPassword field match. Finally, it calls the built in repository save method
 to save the user object to the database.
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
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Validated
public class RegistrationController {

    UserRepository userRepository;
    private UserController userController;
    @Qualifier
    private UserServiceImpl userServiceImpl;
    private UserValidator userValidator;
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);
    @Qualifier("userValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "lastName") String lastName,
                                 @RequestParam(value = "address") String address,
                                 @RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "confirmPassword") String confirmPassword) {
        UserValidator userValidator = new UserValidator();
        if (password.equals(confirmPassword)) {
            User user = new User(firstName, lastName, address, email, password, "user");
            userRepository.save(user);
            return new ModelAndView(new RedirectView("/registerSuccess", true));
        }
        return new ModelAndView("register");
    }

    //Dashboard - To display "Welcome {firstname} in dashboard.
//    @PostMapping("/register")
//    public String submituser(@ModelAttribute("user") User user) {
//        System.out.println(user.getFirstName());
//        return "dashboard";
//    }
}

