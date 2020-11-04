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

