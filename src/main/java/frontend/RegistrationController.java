package frontend;

import comp3095_mayflower.demo.backend.UserController;
import comp3095_mayflower.demo.backend.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class RegistrationController {

    UserRepository userRepository;
    private UserController userController;

    @Autowired
    public RegistrationController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @RequestMapping("/register")
    public String showRegisterPage(){
        return "register";
    }

    /*@RequestMapping(value="/register",method= RequestMethod.POST)
    public ModelAndView register(@RequestParam(value="firstName")String firstName,@RequestParam(value="lastName")String lastName,@RequestParam(value="address")String address,@RequestParam(value="email")String email,@RequestParam(value="password")String password,@RequestParam(value="confirmPassword")String confirmPassword){

    }
*/

}
