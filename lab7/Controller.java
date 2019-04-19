package sample;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private TextField amount;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private TextArea textArea;

    MonteCarlo task;

    @FXML
    private void drawMonteCarlo(ActionEvent event){
        int amountOfPoints=Integer.parseInt(amount.getText());
        GraphicsContext gc=canvas.getGraphicsContext2D();
        task=new MonteCarlo(gc,amountOfPoints);
        progressBar.progressProperty().bind(task.progressProperty());
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                       double result= (double) task.getValue();
                       textArea.setText(String.valueOf(result));
            }
        }
        );
        new Thread(task).start();
    }

    @FXML
    private void stopFunction(ActionEvent event){
        task.cancel(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
