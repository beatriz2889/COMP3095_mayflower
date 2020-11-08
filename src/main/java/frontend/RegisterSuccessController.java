/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #2 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-11-08
 * Description: This is the controller for the registerSuccess page. The URL mapping for the
 page is shown here.
 ***************************************************************************************************/

package frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterSuccessController {

    @RequestMapping("/registerSuccess")
    public String showRegisterSuccessPage(){
        return "registerSuccess";
    }
}
