package comp3095_mayflower.demo.backend;
import org.springframework.stereotype.Service;


@Service
public interface UserService{


    User findByEmail(String email);
    User findByPassword(String password);
}
