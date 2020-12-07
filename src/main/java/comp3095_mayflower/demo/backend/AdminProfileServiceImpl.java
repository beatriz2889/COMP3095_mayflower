/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the implementation class of the AdminProfileService class. This is where the
 repository methods are fully defined. These methods will be used in the AdminProfileController class.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend;
import comp3095_mayflower.demo.backend.entities.AdminProfile;
import comp3095_mayflower.demo.backend.repositories.AdminProfileRepository;
import comp3095_mayflower.demo.backend.services.AdminProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminProfileServiceImpl implements AdminProfileService {

    @Autowired
    private AdminProfileRepository adminProfileRepository;

    public List<AdminProfile> findByUser_Id(int id){
        var it=adminProfileRepository.findByUser_Id(id);
        var adminprofiles=new ArrayList<AdminProfile>();
        it.forEach(e->adminprofiles.add(e));
        return adminprofiles;

    }


}
