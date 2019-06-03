package justyna.lab11.services;

import justyna.lab11.exceptions.Error404;
import justyna.lab11.models.Answer;
import justyna.lab11.models.Survey;
import justyna.lab11.models.User;
import justyna.lab11.repositories.AnswerRepository;
import justyna.lab11.repositories.SurveyRepository;
import justyna.lab11.repositories.UserRepository;
import justyna.lab11.web.response.StatsAll;
import justyna.lab11.web.response.StatsPerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllRepositories {

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private UserRepository userRepository;

    public StatsPerUser statsPerUser(Long id){
        if(userRepository.findById(id)==null){
            throw new Error404();
        }
        int amountOfOfSurveys = surveyRepository.countByUserId(id);
        double[] averageRating = new double[amountOfOfSurveys];
        int[] numberOfAnswers = new int[amountOfOfSurveys];
        List<Survey> list = surveyRepository.findAllByUserId(id);
        int i = 0;
        for(Survey survey:list){
            numberOfAnswers[i] = answerRepository.countBySurveyId(survey.getId());
            List<Answer> list1 = answerRepository.findAllBySurveyId(id);
            double sumOfRatings = 0;
            for(Answer answer:list1){
                sumOfRatings+=answer.getRating();
            }
            averageRating[i]=sumOfRatings/numberOfAnswers[i];
        }
        return new StatsPerUser(amountOfOfSurveys,averageRating,numberOfAnswers);
    }

    public StatsAll statsAll() {
        int amountOfSurveys = (int) surveyRepository.count();

        double averageAmountOfAnswersPerSurvey;
        List<User> list = userRepository.findAll();
        int amountOfSurveysPerUser =0;
        int i=0;
        for(User user:list){
            amountOfSurveysPerUser+= surveyRepository.countByUserId(user.getId());
            i++;
        }
        double averageAmountOfSurveysPerUser = amountOfSurveysPerUser/list.size();

        return new StatsAll();
    }
}
