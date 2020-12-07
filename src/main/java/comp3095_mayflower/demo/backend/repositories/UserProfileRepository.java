/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the repository for our user profile table. It is a CRUD repository, so it has built in
 functionality for creating, updating and deleting user profiles. There are four custom methods defined here:
 findAllByUser_Id,findByFirstName,findByLastname and findByDob, which will be used in the
 user profile controller.
 ***************************************************************************************************/


package comp3095_mayflower.demo.backend.repositories;
import comp3095_mayflower.demo.backend.entities.CreditProfile;
import comp3095_mayflower.demo.backend.entities.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile,Integer> {

    Iterable<UserProfile>findAllByUser_Id(int id);
    UserProfile findByFirstname(String firstname);
    UserProfile findByLastname(String lastname);
    UserProfile findByDob(Date dob);

}
