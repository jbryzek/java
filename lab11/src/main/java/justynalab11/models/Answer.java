package justyna.lab11.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int surveyId;
    private int userId;
    private int rating;

    public Answer(@JsonProperty("surveyId") int surveyId, @JsonProperty("rating") int rating) {
        this.surveyId = surveyId;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public int getUserId() {
        return userId;
    }
}
