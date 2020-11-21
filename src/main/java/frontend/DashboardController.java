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

    @RequestMapping("/admindashboard")
    public String showAdminDashboardPage(){return "admindashboard";}

    @RequestMapping("/myprofileuser")
    public String showUserProfilePage() {
        return "myprofileuser";
    }

    @RequestMapping("/creditprofile")
    public String showCreditProfilePage() {
        return "creditprofile";
    }

    @RequestMapping("/inboxuser")
    public String showUserInboxPage() {
        return "inboxuser";
    }

    @RequestMapping("/supportuser")
    public String showUserSupportPage() {
        return "supportuser";
    }

    @RequestMapping("/myprofileadmin")
    public String showAdminProfilePage(){return "myprofileadmin";}

    @RequestMapping("/users")
    public String showUsersPage(){return "users";}

    @RequestMapping("/inboxadmin")
    public String showAdminInboxPage(){return "inboxadmin";}

    @RequestMapping("/supportadmin")
    public String showAdminSupportPage(){return "supportadmin";}
}
