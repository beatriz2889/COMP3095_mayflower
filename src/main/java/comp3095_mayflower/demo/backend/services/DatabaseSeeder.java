/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the database seeder class. It is responsible for creating the admin
 user when the application starts.
 ***************************************************************************************************/


package comp3095_mayflower.demo.backend.services;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
public class DatabaseSeeder implements CommandLineRunner {

     static Logger logger = Logger.getLogger(DatabaseSeeder.class.getName());

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (userRepository.count() == 0) {
            User user = new User("admin", "admin", "123 admin road", "admin@isp.net", "P@ssword1", "admin");
            userRepository.save(user);
            logger.info("User seeded");


        } else {
           logger.info("Seeding not required");
        }
    }
}
