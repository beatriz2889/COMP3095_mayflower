package frontend;

import comp3095_mayflower.demo.backend.User;
import comp3095_mayflower.demo.backend.UserRepository;
import comp3095_mayflower.demo.backend.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication//(scanBasePackages = {"comp3095_mayflower.demo.backend"})
@EnableJpaRepositories(basePackages={"comp3095_mayflower.demo.backend"})
@EntityScan(basePackageClasses = User.class)
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
    private UserRepository userRepository;
    //private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);

        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");

       // UserRepository userRepository=(UserRepository)ctx.getBean("userRepository");

        UserServiceImpl userServiceImpl = (UserServiceImpl) ctx.getBean("userService");

        //UserController userController=(UserController)ctx.getBean("userController");
    }

    /*@Bean
    public UserService userService(){
        return new UserImpl();

    }*/



 /* @Bean
    public void setUserRepository(UserRepository userRepository){
        this.userRepository=userRepository;
    }*/

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
