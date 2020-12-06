package comp3095_mayflower.demo.backend.repositories;

import comp3095_mayflower.demo.backend.entities.Support;
import comp3095_mayflower.demo.backend.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository()
public interface SupportRepository extends CrudRepository<Support,String> {
    Support findByFirstname(String firstname);

    @Override
    void deleteById(String firstname);
}
