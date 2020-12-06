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

import comp3095_mayflower.demo.backend.controllers.UserController;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.SupportRepository;
import comp3095_mayflower.demo.backend.UserServiceImpl;
import comp3095_mayflower.demo.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {
    @Qualifier
    private UserServiceImpl userServiceImpl;
    UserRepository userRepository;
    SupportRepository supportRepository;
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


    @GetMapping("users")
    public String showUserList(Model model){
        model.addAttribute("users",userRepository.findAll());
        return"userlist";
    }
    @GetMapping("list")
    public String showInbox(Model model)
    {
        model.addAttribute("list",supportRepository.findAll());
        return "inboxuser";

    }
    @GetMapping("users/delete/{id}")
    public String deleteUser(@PathVariable(value="id")int id,Model model){
        User user=userRepository.findById(id).orElseThrow(()->new IllegalArgumentException(("Invalid user id:"+id)));
        userRepository.delete(user);
        model.addAttribute("users",userRepository.findAll());
        return "userlist";

    }


    /*
    @RequestMapping(value="/users",method= RequestMethod.GET)
    public String userList(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "userlist";
    }*/







    /*
    @RequestMapping(value="/users{id}",method=RequestMethod.GET){
        public String deleteUser(@PathVariable int id){
            userRepository.deleteById(id);
            return "userList";
        }
    }*/



    /*
    @RequestMapping("/userlist")
    public String showUsersPage(){return "userlist";}
     */
    @RequestMapping("/inboxadmin")
    public String showAdminInboxPage(){return "inboxadmin";}

    @RequestMapping("/supportadmin")
    public String showAdminSupportPage(){return "supportadmin";}
}
