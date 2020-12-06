/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the controller class for the users list page. All the functions
 (viewing all the users, deleting a user and accessing the page are defined here. The page
 is also locked to users who have not logged in using the user session controller and client users.
 There is also some code in place to prevent the currently logged in admin from deleting themselves
 off the user list.
 ***************************************************************************************************/


package frontend;

import comp3095_mayflower.demo.backend.UserServiceImpl;
import comp3095_mayflower.demo.backend.controllers.UserController;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserListController {

    @Qualifier
    private UserServiceImpl userServiceImpl;
    UserRepository userRepository;
    private UserController userController;

    public UserListController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("users")
    public ModelAndView showUserList(Model model){
        User user=UserSessionController.loggedInUser;
        if(user==null||user.getRole().equals("user")){
            return new ModelAndView("login");
        }
        model.addAttribute("users",userRepository.findAll());
        return new ModelAndView("userlist");
    }

    @GetMapping("users/delete/{id}")
    public String deleteUser(@PathVariable(value="id")int id, Model model) {

        User currentUser = UserSessionController.loggedInUser;
        User isUserLoggedIn=userRepository.findById(currentUser.getId());
        User user = userRepository.findById(id);

        if (isUserLoggedIn.equals(user)) {
            model.addAttribute("users",userRepository.findAll());
            return "userlist";


        } else {
            userRepository.delete(user);
            model.addAttribute("users", userRepository.findAll());
            return "userlist";

        }
    }
}
