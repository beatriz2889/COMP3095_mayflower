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

import comp3095_mayflower.demo.backend.CreditServiceImpl;
import comp3095_mayflower.demo.backend.controllers.UserController;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.AdminProfileRepository;
import comp3095_mayflower.demo.backend.repositories.CreditProfileRepository;
import comp3095_mayflower.demo.backend.repositories.UserRepository;
import comp3095_mayflower.demo.backend.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
    @Qualifier
    private UserServiceImpl userServiceImpl;
    UserRepository userRepository;
    CreditProfileRepository creditProfileRepository;
    AdminProfileRepository adminProfileRepository;
    private UserController userController;
    private CreditServiceImpl creditServiceImpl;

    @Autowired
    public DashboardController(UserRepository userRepository, CreditProfileRepository creditProfileRepository, AdminProfileRepository adminProfileRepository) {
        this.userRepository = userRepository;
        this.creditProfileRepository=creditProfileRepository;
        this.adminProfileRepository=adminProfileRepository;

    }

    @RequestMapping("/dashboard")
    public ModelAndView showDashboardPage() {
        User user=UserSessionController.loggedInUser;
        if(user==null){
            return new ModelAndView("login");

        }
        return new ModelAndView("dashboard");
    }

    @RequestMapping("/admindashboard")
    public ModelAndView showAdminDashboardPage(Model model){
        User user = UserSessionController.loggedInUser;
        model.addAttribute("adminprofiles", adminProfileRepository.findByUser_Id(user.getId()));
        model.addAttribute("clientusers",userRepository.findAllByRole("user"));
        return new ModelAndView("admindashboard");
    }
    @RequestMapping("/inboxuser")
    public String showUserInboxPage() {
        return "inboxuser";
    }

    @RequestMapping("/supportuser")
    public ModelAndView showUserSupportPage() {
        User user=UserSessionController.loggedInUser;
        if(user==null){
            return new ModelAndView("login");
        }
        return new ModelAndView("supportuser");
    }

    @RequestMapping("/inboxadmin")
    public String showAdminInboxPage(){return "inboxadmin";}

}
