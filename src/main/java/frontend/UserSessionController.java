/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the user session controller. This controller class will be used to
 handle the session tracking required for all of the pages for this assignment. How it works
 is you call the controller's logged in user and you can use it in conjunction with the
 repositories to get the data for the logged in user by getting the user id. It is also used
 to lock pages according to role and whether the current logged in user is null, which means
 they haven't logged in. In the login function, the controller is called and the logged in user
 is set to the user who is logging in. That is how I handled session tracking for this assignment.
 ***************************************************************************************************/

package frontend;

import comp3095_mayflower.demo.backend.entities.User;
import org.springframework.stereotype.Controller;

@Controller
public class UserSessionController {

    public static User loggedInUser;
}
