/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the implementation class of the CreditService class. This is where the
 repository methods are fully defined. These methods will be used in the CreditProfileFrontendController class.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend;
import comp3095_mayflower.demo.backend.entities.CreditProfile;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.CreditProfileRepository;
import comp3095_mayflower.demo.backend.services.CreditService;
import frontend.UserSessionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditProfileRepository creditProfileRepository;

    @Override
    public Iterable<CreditProfile> findAllByUser_Id(int id){
        var it=creditProfileRepository.findAllByUser_Id(id);
        var creditprofiles=new ArrayList<CreditProfile>();
        it.forEach(e->creditprofiles.add(e));
        System.out.println(creditprofiles);
        return creditprofiles;

    }

    @Override
    public CreditProfile findByCardnum(int cardnum){
        return creditProfileRepository.findByCardnum(cardnum);
    }
}
