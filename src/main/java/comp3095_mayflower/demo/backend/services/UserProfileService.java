/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the user profile service class. The repository methods are defined here again so
 they can be used in the UserProfileServiceImpl class.
 ***************************************************************************************************/


package comp3095_mayflower.demo.backend.services;
import comp3095_mayflower.demo.backend.entities.CreditProfile;
import comp3095_mayflower.demo.backend.entities.UserProfile;
import java.util.Date;
import java.util.List;

public interface UserProfileService {

    Iterable<UserProfile>findAllByUser_Id(int id);
   // List<UserProfile>findByUser_Id(int id);
    UserProfile findByFirstname(String firstname);
    UserProfile findByLastname(String lastname);
    UserProfile findByDob(Date dob);
}
