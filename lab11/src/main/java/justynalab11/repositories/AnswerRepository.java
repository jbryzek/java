package justyna.lab11.repositories;

import justyna.lab11.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findAllBySurveyId(Long id);
    //Answer updateAnswer(Answer answer);
    int countBySurveyId(Long id);
}
