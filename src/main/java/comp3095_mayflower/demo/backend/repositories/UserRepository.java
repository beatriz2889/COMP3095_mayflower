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

package comp3095_mayflower.demo.backend.repositories;
import comp3095_mayflower.demo.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository extends CrudRepository
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

   User findByEmail(String email);
   User findByPassword(String password);

   //Alan Dashboard - Me trying to make a CRUD
   List<User> findByName(String firstname);
}

