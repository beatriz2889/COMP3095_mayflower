/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #2 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-11-08
 * Description: This is the implementation class of the UserService class. This is where the
 repository methods are fully defined. These methods will be used in the UserController class.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend;

import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.UserRepository;
import comp3095_mayflower.demo.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByPassword(String password){
        return userRepository.findByPassword(password);
    }

    @Override
    public List<User> getAllUsers(){
        var it=userRepository.findAll();
        var users=new ArrayList<User>();
        it.forEach(e->users.add(e));
        return users;
    }



}
