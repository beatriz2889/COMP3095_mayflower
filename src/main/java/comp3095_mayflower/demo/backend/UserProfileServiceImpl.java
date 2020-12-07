/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the implementation class of the UserProfileService class. This is where the
 repository methods are fully defined. These methods will be used in the UserProfileController class.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.entities.UserProfile;
import comp3095_mayflower.demo.backend.repositories.UserProfileRepository;
import comp3095_mayflower.demo.backend.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public Iterable<UserProfile>findAllByUser_Id(int id){
        var it=userProfileRepository.findAllByUser_Id(id);
        var userprofiles=new ArrayList<UserProfile>();
        it.forEach(e->userprofiles.add(e));
        return userprofiles;
    }

    public UserProfile findByFirstname(String firstname){
        return userProfileRepository.findByFirstname(firstname);
    }

    public UserProfile findByLastname(String lastname){
        return userProfileRepository.findByLastname(lastname);
    }

    public UserProfile findByDob(Date dob){
        return userProfileRepository.findByDob(dob);

    }
}
