package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowController implements Initializable{
    @FXML private TextField titleItem;
    @FXML private ChoiceBox priorityItem;
    @FXML private DatePicker expDateItem=new DatePicker();
    @FXML private TextField descriptionItem;
    private Listener listener;
    interface Listener {
        void onElementItem(Item item);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        priorityItem.getItems().add("HIGH");
        priorityItem.getItems().add("MEDIUM");
        priorityItem.getItems().add("LOW");
        priorityItem.getSelectionModel().selectFirst();
    }

    public void handleClick(ActionEvent event){
        Item selectedItem = new Item();
        selectedItem.setTitle(titleItem.getText());
        selectedItem.setPriority(priorityItem.getValue());
        selectedItem.setExpDate( expDateItem.getValue());
        selectedItem.setDescription(descriptionItem.getText());
        if(this.listener != null)
            this.listener.onElementItem(selectedItem);

        Stage stage = (Stage) titleItem.getScene().getWindow();
        stage.close();

    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


}
