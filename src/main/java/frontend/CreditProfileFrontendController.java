package frontend;

import comp3095_mayflower.demo.backend.CreditProfile;
import comp3095_mayflower.demo.backend.CreditProfileBackendController;
import comp3095_mayflower.demo.backend.CreditProfileRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class CreditProfileFrontendController {

    CreditProfileRepository creditProfileRepository;
    private CreditProfileBackendController creditProfileBackendController;
    private static final Logger log= LoggerFactory.getLogger(CreditProfileFrontendController.class);

    @Autowired
    public CreditProfileFrontendController(CreditProfileRepository creditProfileRepository){this.creditProfileRepository=creditProfileRepository;}

   @RequestMapping(value="/creditprofile",method= RequestMethod.POST)
    public ModelAndView addCreditProfile(@RequestParam(value="cardType")String cardType,
                                         @RequestParam(value="expDate") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")LocalDateTime expDate,
                                         @RequestParam(value="name")String name,
                                         @RequestParam(value="cardNum") Integer cardNum,
                                         @RequestParam(value="defaultCard")Boolean defaultCard){

        if(defaultCard.booleanValue()){
       CreditProfile creditProfile=new CreditProfile(cardType,expDate,name,cardNum,true);
       creditProfileRepository.save(creditProfile);
       return new ModelAndView("creditprofile");


   }
        CreditProfile creditProfile=new CreditProfile(cardType,expDate,name,cardNum,false);
        creditProfileRepository.save(creditProfile);
        return new ModelAndView("creditprofile");


   }
}
