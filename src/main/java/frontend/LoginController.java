package frontend;

import comp3095_mayflower.demo.backend.User;
import comp3095_mayflower.demo.backend.UserController;
import comp3095_mayflower.demo.backend.UserRepository;
import comp3095_mayflower.demo.backend.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@Controller

public class LoginController {
   // @Autowired
   // UserService userService;
    @Qualifier
    private UserServiceImpl userServiceImpl;
   // @Autowired
    private UserRepository userRepository;
    private UserController userController;
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public String login(@RequestParam(value="email")String email,@RequestParam(value="password")String password){
      User user=new User();
        /*if(email.equals(userRepository.findByEmail(email))&&password.equals(userRepository.findByPassword(password))){
            log.info("function works");
        }*/
        //return "login";
        try {
            user = userController.getUserByEmail(email);
            log.info(String.valueOf(userRepository.findById(1)));
        }
        catch (NullPointerException exception){
            log.info(exception.toString());
        }
        log.info(user.toString());
        return "login";

    }

}
