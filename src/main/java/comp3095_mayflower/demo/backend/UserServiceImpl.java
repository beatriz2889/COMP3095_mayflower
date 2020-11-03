package comp3095_mayflower.demo.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {





    @Autowired
    private UserRepository userRepository;
   /* public void setUserRepository(UserRepository userRepository){
        this.userRepository=userRepository;
    }*/

    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByPassword(String password){
        return userRepository.findByPassword(password);
    }



}
