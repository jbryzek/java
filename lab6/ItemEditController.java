package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemEditController implements Initializable {
    @FXML private TextField titleItem;
    @FXML private ChoiceBox priorityItem;
    @FXML private DatePicker expDateItem=new DatePicker();
    @FXML private TextField descriptionItem;
    private ListView listView;
    private Item item;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        priorityItem.getItems().add("HIGH");
        priorityItem.getItems().add("MEDIUM");
        priorityItem.getItems().add("LOW");
    }

    public void setItemToEdit(Item item, ListView listView) {
        this.listView=listView;
        this.item = item;
        titleItem.setText(item.getTitle());
        priorityItem.setValue(item.getPriority());
        expDateItem.setValue(item.getExpDate());
        descriptionItem.setText(item.getDescription());
    }

    public void editItem(ActionEvent event) {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        listView.getItems().remove(selectedIndex);

        item.setTitle(titleItem.getText());
        item.setExpDate(expDateItem.getValue());
        item.setPriority(priorityItem.getValue());
        item.setDescription(descriptionItem.getText());
        listView.getItems().add(item);
        closeClicked(event);
    }

    public void closeClicked(ActionEvent event){
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
