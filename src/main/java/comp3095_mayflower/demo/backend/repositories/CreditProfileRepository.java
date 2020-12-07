/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the repository for our credit profile table. It is a CRUD repository, so it has built in
 functionality for creating, updating and deleting credit profiles. There are two custom methods defined here:
 findAllByUser_Id and findByCardNum, which will be used in the credit profile frontend controller.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend.repositories;
import comp3095_mayflower.demo.backend.entities.CreditProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditProfileRepository extends CrudRepository<CreditProfile,Integer> {

    Iterable<CreditProfile>findAllByUser_Id(int id);
    CreditProfile findByCardnum(int cardnum);

}
