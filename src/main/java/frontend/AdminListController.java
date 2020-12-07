package frontend;

import org.springframework.stereotype.Controller;
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
public class AdminListController {
    @Qualifier
    private UserServiceImpl userServiceImpl;
    UserRepository userRepository;
    private UserController userController;

    public AdminListController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("adminList")
    public ModelAndView showAdminList(Model model){
        User user=UserSessionController.loggedInUser;
        if(!user.getRole().equals("admin")){
            return new ModelAndView("login");
        }
        model.addAttribute("users",userRepository.findByRole("admin"));
        return new ModelAndView("adminlist");
    }
    /*@GetMapping("users/delete/{id}")
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
    }*/
}
