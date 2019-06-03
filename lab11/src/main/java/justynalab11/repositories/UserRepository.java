package justyna.lab11.repositories;

import justyna.lab11.models.Survey;
import justyna.lab11.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findAll();
}
