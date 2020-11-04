package frontend;

import comp3095_mayflower.demo.backend.UserController;
import comp3095_mayflower.demo.backend.UserRepository;
import comp3095_mayflower.demo.backend.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DashboardController {
    @Qualifier
    private UserServiceImpl userServiceImpl;
    // @Autowired
    UserRepository userRepository;
    private UserController userController;

    @Autowired
    public DashboardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/dashboard")
    public String showDashboardPage() {
        return "dashboard";
    }



}
