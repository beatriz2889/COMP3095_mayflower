package comp3095_mayflower.demo.backend;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findByEmail(String email);
    User findByPassword(String password);
}
