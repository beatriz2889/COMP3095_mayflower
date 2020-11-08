/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #2 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-11-08
 * Description: This is the controller for the dashboard page. The url mappings for all of the
 relevant links (dashboard page, tabs) are defined here.
 ***************************************************************************************************/


package frontend;

import comp3095_mayflower.demo.backend.UserController;
import comp3095_mayflower.demo.backend.UserRepository;
import comp3095_mayflower.demo.backend.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @Qualifier
    private UserServiceImpl userServiceImpl;
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

    @RequestMapping("/tab1")
    public String showTab1Page() {
        return "tab1";
    }

    @RequestMapping("/tab2")
    public String showTab2Page() {
        return "tab2";
    }

    @RequestMapping("/tab3")
    public String showTab3Page() {
        return "tab3";
    }

    @RequestMapping("/tab4")
    public String showTab4Page() {
        return "tab4";
    }
}
