/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #2 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-11-08
 * Description: This is the user service class. The repository methods are defined here again so
 they can be used in the UserServiceImpl class.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend.services;

import comp3095_mayflower.demo.backend.entities.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email);
    User findByPassword(String password);
    List getAllUsers();
    List <User> findByRole(String role);
    //Iterable<User>findAllByRole(String role);
    User findById(int id);
    List<User>findAllByRole(String role);

}
