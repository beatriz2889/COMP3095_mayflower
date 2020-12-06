/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the admin profile service class. The repository methods are defined here again so
 they can be used in the AdminProfileServiceImpl class.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend.services;
import comp3095_mayflower.demo.backend.entities.AdminProfile;
import java.util.List;
import java.util.Optional;

public interface AdminProfileService {

    List<AdminProfile> findByUser_Id(int id);
}
