package comp3095_mayflower.demo.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{email}")
    public User getUserByEmail(@PathVariable(value = "email") String email) {
        return userRepository.findByEmail(email);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{password}")
    public User getUserByPassword(@PathVariable(value = "password") String password) {
        return userRepository.findByPassword(password);
    }
}
/*
    @GetMapping("/user/{email/password}")
    public User getUserByEmailAndPassword(@PathVariable(value="email",="password") String email,String password)

}*/
