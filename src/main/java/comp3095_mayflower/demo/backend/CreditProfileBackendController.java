package comp3095_mayflower.demo.backend;

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
