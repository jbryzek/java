package justyna.lab11.repositories;

import justyna.lab11.models.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {
    List<Survey> findAllByUserId(Long userId);
    List<Survey> findAll();
    Optional<Survey> findById(Long surveyId);
    int countByUserId(Long id);

    //void delete(Optional<Survey> byId);
}
