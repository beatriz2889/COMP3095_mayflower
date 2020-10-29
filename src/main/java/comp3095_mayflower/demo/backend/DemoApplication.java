package comp3095_mayflower.demo.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import comp3095_mayflower.demo.backend.UserController;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
      //  ApplicationContext ctx=SpringApplication.run(DemoApplication.class,args);

        //UserController userController=(UserController)ctx.getBean("userController");
    }

   /* @Bean
    public CommandLineRunner demo(UserRepository rep) {
        return (args) -> {
            rep.save(new User("Beatriz","Morales","145 Road","b@gmail.com","pass","user"));
            for (User user : rep.findAll()) {
                log.info(user.toString());
            };


        };
    }*/

}
