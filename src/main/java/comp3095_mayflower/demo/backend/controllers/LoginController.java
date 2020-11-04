package comp3095_mayflower.demo.backend.controllers;

import comp3095_mayflower.demo.backend.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    //to get login form page
    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String getLoginForm(){
        return "login";
    }
    //check for login credentials
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm")LoginForm loginForm, Model model){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        //if username and password are correct go to dashboard page
        if("admin".equals(username) && "admin".equals(password)){
            return "dashboard";
        }
        //if username or password is wrong return to login page
        model.addAttribute("invalidCredentials", true);
        return "login";
    }
}
