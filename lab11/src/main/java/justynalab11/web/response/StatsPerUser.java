package justyna.lab11.web.response;

public class StatsPerUser {
    int numberOfSurveys;
    double[] averageRating;
    int[] numberOfAnswers;

    public StatsPerUser(int numberOfSurveys, double[] averageRating, int[] numberOfAnswers){
        this.numberOfSurveys = numberOfSurveys;
        this.averageRating = averageRating;
        this.numberOfAnswers = numberOfAnswers;
    }
}
