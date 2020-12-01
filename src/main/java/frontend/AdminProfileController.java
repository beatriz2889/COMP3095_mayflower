package frontend;

import comp3095_mayflower.demo.backend.UserServiceImpl;
import comp3095_mayflower.demo.backend.controllers.UserController;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AdminProfileController {
    @Qualifier
    private UserServiceImpl userServiceImpl;
    UserRepository userRepository;
    private UserController userController;

    @Autowired
    public AdminProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("update/{id}")
    public String updateAdminProfile(@PathVariable("id")int id, @Valid User user, Model model, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            user.setId(id);
            return"myprofileadmin";
        }
        userRepository.save(user);
        model.addAttribute("user",userRepository.findById(id));
        return "myprofileadmin";

    }
}
