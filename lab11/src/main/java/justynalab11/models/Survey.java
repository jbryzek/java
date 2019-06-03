package justyna.lab11.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is mandatory")
    private String surveyTitle;
    @NotBlank(message = "Question is mandatory")
    private String question;
    private int userId;

    public Survey(@JsonProperty("surveyTitle") String surveyTitle, @JsonProperty("question") String question) {
        this.surveyTitle = surveyTitle;
        this.question = question;
    }


    public Long getId() {
        return id;
    }
}
