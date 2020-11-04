package comp3095_mayflower.demo.backend;

public interface UserService {

    User findByEmail(String email);
    User findByPassword(String password);
   // User findByEmailAndPassword(String email, String password);
}
