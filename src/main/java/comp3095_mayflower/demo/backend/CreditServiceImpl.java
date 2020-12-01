package comp3095_mayflower.demo.backend;

import comp3095_mayflower.demo.backend.entities.CreditProfile;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.CreditProfileRepository;
import comp3095_mayflower.demo.backend.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditProfileRepository creditProfileRepository;

    /*
    @Override
    public List<CreditProfile> getAllCreditProfiles(){
        var it=creditProfileRepository.findAll();
        var creditprofiles=new ArrayList<CreditProfile>();
        it.forEach(e->creditprofiles.add(e));
        return creditprofiles;
    }*/
}
