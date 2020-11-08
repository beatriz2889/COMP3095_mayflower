/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #2 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-11-08
 * Description: This is the repository for our database. It is a CRUD repository, so it has built in
 functionality for creating, updating and deleting users. There are two custom methods defined here:
 findByEmail and findByPassword, which will be used in the login function.
 ***************************************************************************************************/


package comp3095_mayflower.demo.backend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

  // @Query("SELECT DISTINCT User FROM User WHERE User.email LIKE :email%")
   //User findByEmail(@Param("email")String email);
   User findByEmail(String email);



  // User findByEmail(String email);
   User findByPassword(String password);


   //User findByEmailAndPassword(String email, String password);




}

