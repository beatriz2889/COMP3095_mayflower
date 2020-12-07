/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: Empty controller class for credit profile page. Using the credit profile
 frontend controller instead
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend.controllers;
import comp3095_mayflower.demo.backend.CreditServiceImpl;
import comp3095_mayflower.demo.backend.entities.CreditProfile;
import comp3095_mayflower.demo.backend.repositories.CreditProfileRepository;
import comp3095_mayflower.demo.backend.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CreditProfileBackendController {

    @Autowired
    private CreditService creditService;

    @Autowired
    private CreditProfileRepository creditProfileRepository;

    @Autowired
    private CreditServiceImpl creditServiceImpl;

    public CreditProfileBackendController(CreditProfileRepository creditProfileRepository){
        this.creditProfileRepository=creditProfileRepository;
    }
}
