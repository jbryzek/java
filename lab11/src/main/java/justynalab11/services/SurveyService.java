package justyna.lab11.services;

import justyna.lab11.exceptions.Error404;
import justyna.lab11.exceptions.Status204;
import justyna.lab11.models.Survey;
import justyna.lab11.repositories.AnswerRepository;
import justyna.lab11.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private AnswerRepository answerRepository;

    public Survey addSurvey(Survey survey){
        return surveyRepository.save(survey);
    }

    public List<Survey> getSurveysOfUser(Long id) {
        checkIfExist(id);
        return surveyRepository.findAllByUserId(id);
    }

    public List<Survey> listOfSurveys() {
        return surveyRepository.findAll();
    }

    public void deleteSurvey(Long id) {
        checkIfExist(id);
        //surveyRepository.delete(surveyRepository.findById(id));
        answerRepository.deleteAll(answerRepository.findAllBySurveyId(id));
        throw new Status204();
    }

    public void checkIfExist(Long id){
        if(surveyRepository.findById(id)==null){
            throw new Error404();
        }
    }
}
