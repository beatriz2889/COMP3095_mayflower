/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #2 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-11-08
 * Description: This is the Controller for the User class. It contains the mappings for the repository
 methods that are defined in the UserServiceImpl class.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend.controllers;

import comp3095_mayflower.demo.backend.UserServiceImpl;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.UserRepository;
import comp3095_mayflower.demo.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{email}")
    public User getUserByEmail(@PathVariable(value = "email") String email) {
        return userRepository.findByEmail(email);
    }

    @GetMapping("/user/{password}")
    public User getUserByPassword(@PathVariable(value = "password") String password) {
        return userRepository.findByPassword(password);
    }






    /*
   @DeleteMapping("/users/{id}")
    public Map<String,Boolean> deleteUser(@PathVariable(value="id")int id){
        User user=userRepository.findById(id);
        userRepository.delete(user);
   }*/



}

