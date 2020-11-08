/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #2 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-11-08
 * Description: The main class of the application. Various annotations are used here in order to
 use the needed files. @EnableJpaRepositories is used to scan the backend folder in order to locate
 the UserRepository file. @EntityScan is used to locate the User class. The application context is
 established here in order to use the beans defined in our beans.xml file. Since the repository
 could not be directly instantiated as a bean due to it being an abstract bean another bean of the
 UserServiceImpl class is used and inherits from the repository.

 ***************************************************************************************************/

package frontend;

import comp3095_mayflower.demo.backend.*;
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
