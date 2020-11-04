package frontend;

import comp3095_mayflower.demo.backend.UserController;
import comp3095_mayflower.demo.backend.UserRepository;
import comp3095_mayflower.demo.backend.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    // @Autowired
    // UserService userService;
    @Qualifier
    private UserServiceImpl userServiceImpl;
    // @Autowired
    private UserRepository userRepository;
    private UserController userController;
    @RequestMapping("/register")
    public String showRegistrationPage(){
        return "register";
    }

}
