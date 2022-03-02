package daniel.nofulla.customsearchenginebackend.repositories;

import daniel.nofulla.customsearchenginebackend.entities.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

}
