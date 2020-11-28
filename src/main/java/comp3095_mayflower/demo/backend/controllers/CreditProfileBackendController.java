package comp3095_mayflower.demo.backend.controllers;

import comp3095_mayflower.demo.backend.repositories.CreditProfileRepository;
import comp3095_mayflower.demo.backend.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CreditProfileBackendController {

    @Autowired
    private CreditService creditService;

    @Autowired
    private CreditProfileRepository creditProfileRepository;

    public CreditProfileBackendController(CreditProfileRepository creditProfileRepository){
        this.creditProfileRepository=creditProfileRepository;
    }
}
