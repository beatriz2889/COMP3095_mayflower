/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the repository for our admin profile table. It is a CRUD repository, so it has built in
 functionality for creating, updating and deleting admin profiles. There is one custom method defined here:
 findByUser_Id, which will be used in the admin profile controller.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend.repositories;
import comp3095_mayflower.demo.backend.entities.AdminProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminProfileRepository extends CrudRepository<AdminProfile,Integer> {

    List<AdminProfile> findByUser_Id(int id);
}
