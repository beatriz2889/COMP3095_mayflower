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
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.*;
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
    private CreditProfileRepository creditProfileRepository;
    private UserProfileRepository userProfileRepository;
    private AdminProfileRepository adminProfileRepository;
    private MessagesRepository messagesRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);

        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");

        UserServiceImpl userServiceImpl = (UserServiceImpl) ctx.getBean("userService");
        CreditServiceImpl creditServiceImpl=(CreditServiceImpl)ctx.getBean("creditService");
        UserProfileServiceImpl userProfileService=(UserProfileServiceImpl)ctx.getBean("userProfileService");
        AdminProfileServiceImpl adminProfileService=(AdminProfileServiceImpl)ctx.getBean("adminProfileService");
        MessagesServiceImpl messagesService=(MessagesServiceImpl)ctx.getBean("messagesService");
    }
}
