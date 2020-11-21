package comp3095_mayflower.demo.backend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditProfileRepository extends CrudRepository<CreditProfile,Integer> {
}
