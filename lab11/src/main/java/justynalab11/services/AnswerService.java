package justyna.lab11.services;

import justyna.lab11.exceptions.Error404;
import justyna.lab11.models.Answer;
import justyna.lab11.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Answer addAnswer(@Valid Answer answer) {

        return answerRepository.save(answer);
    }

    public Optional<Answer> getAnswer(Long id) {
        checkIfExist(id);
        return answerRepository.findById(id);
    }

    public Answer putAnswer(int rating, Long id) {
        checkIfExist(id);
        answerRepository.findById(id).map(answer -> {
            answer.setRating(rating);
            return answerRepository.save(answer);
        });
        //Optional<Answer> answer1 = answerRepository.findById(id);
        //Answer answer2 = answer1.get();
        //answer2.setRating(rating);
        //return answerRepository.updateAnswer(answer2);
        //return answer2;
        return null;
    }

    public void checkIfExist(Long id){
        if(answerRepository.findById(id)==null){
            throw new Error404();
        }
    }
}
