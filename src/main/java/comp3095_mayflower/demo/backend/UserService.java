/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #2 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-11-08
 * Description: This is the user service class. The repository methods are defined here again so
 they can be used in the UserServiceImpl class.
 ***************************************************************************************************/


package comp3095_mayflower.demo.backend;

public interface UserService {

    User findByEmail(String email);
    User findByPassword(String password);
   // User findByEmailAndPassword(String email, String password);
}
