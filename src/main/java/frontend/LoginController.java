package frontend;

import comp3095_mayflower.demo.backend.User;
import comp3095_mayflower.demo.backend.UserController;
import comp3095_mayflower.demo.backend.UserRepository;
import comp3095_mayflower.demo.backend.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Controller

public class LoginController {
    // @Autowired
    // UserService userService;
    @Qualifier
    private UserServiceImpl userServiceImpl;
    // @Autowired
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
    public ModelAndView login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        //User user = new User();
        //userRepository.save(new User("admin","admin","123 admin road","admin@isp.net","P@ssword1","admin"));
        User user = userRepository.findByEmail(email);
        if (Objects.nonNull(user) && email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            //try to change url to dashboard

            return new ModelAndView(new RedirectView("/dashboard", true));
        } else {

            //log.info(String.valueOf(userRepository.findByEmail(email)));
            // log.info(String.valueOf(userRepository.findByPassword(password)));

            return new ModelAndView("login");


            //return new ModelAndView("/login");
            //return "login";
        /*try {
            //user = userController.getUserByEmail(email);
            log.info(String.valueOf(userRepository.findByEmail(email)));
            log.info(String.valueOf(userRepository.findByPassword(password)));
        }
        catch (NullPointerException exception){
            log.info(exception.toString());
        }
        //log.info(user.toString());
        return "login";

    }*/

   /* @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String message;
        if(email.equals(userRepository.findByEmail(email)) && password.equals(userRepository.findByPassword(password))){
            message="Welcome"+email+".";
            return new ModelAndView("dashboard","message",message);
        }
        else{
            message="wrong username and/or password";
            return new ModelAndView("login","message",message);
        }
    }*/

   /* @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(@RequestParam(value="email")String email,@RequestParam(value="password")String password){
        User user=new User();
        String userEmail=user.getEmail();
        String userPassword=user.getPassword();

        if(email.equals(userEmail)&& password.equals(userPassword)){
            return "dashboard";

        }
        log.info("didn't work");
        return "login";
    }
*/
        }
    }
}




