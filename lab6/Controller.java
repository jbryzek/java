package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private ListView listView;
    @FXML private ListView listView1;
    @FXML private ListView listView2;

    private int listViewLast = -1;

    public void toNextList(ActionEvent event){
        Item item = (Item) listView.getSelectionModel().getSelectedItem();
        Item item1 = (Item) listView1.getSelectionModel().getSelectedItem();
        if(listViewLast == 0 && listView.getSelectionModel().getSelectedItem()==item){
            deleteItem();
            listView1.getItems().add(item);
        }
        if(listViewLast == 1&& listView1.getSelectionModel().getSelectedItem()==item1){
            deleteItem1();
            listView2.getItems().add(item1);
        }
    }

    public void openWindowItem(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("window.fxml"));
        Parent parent = loader.load();
        loader.<WindowController>getController().setListener(item -> listView.getItems().add(item));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Add new task");
        stage.setScene(scene);
        stage.show();
    }

    public void handleClick(MouseEvent event){
        if(event.getButton() == MouseButton.PRIMARY){

        } else if(event.getButton() == MouseButton.SECONDARY) {
            final ContextMenu contextMenu = new ContextMenu();
            MenuItem delete = new MenuItem("Delete");
            delete.setOnAction(deleteEvent -> deleteItem());
            MenuItem edit = new MenuItem("Edit");
            edit.setOnAction(editEvent -> {
                try {
                    editItem();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            contextMenu.getItems().addAll(delete, edit);
            listView.setContextMenu(contextMenu);
        }
    }

    private void deleteItem() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        listView.getItems().remove(selectedIndex);
    }

    private void deleteItem1() {
        int selectedIndex = listView1.getSelectionModel().getSelectedIndex();
        listView1.getItems().remove(selectedIndex);
    }

    private void editItem() throws IOException {
        Item item = (Item) listView.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ItemEdit.fxml"));
        Parent parent = loader.load();
        loader.<ItemEditController>getController().setItemToEdit(item,listView);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Edit task");
        stage.setScene(scene);
        stage.show();
    }

    public void onCloseRequestProperty(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are you sure you want to close?");
        alert.setHeaderText("Confirm");
        alert.setContentText("Are you sure you want to close?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Platform.exit();
            System.exit(0);
        }
    }

    public void aboutMenuBar(ActionEvent event){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Short information about Author");
        alert.setContentText("Joanna Nowak. She was born on 4th April 1998.");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Item item1 = new Item();
        item1.setTitle("Item1");
        Item item2 = new Item();
        item2.setTitle("Item2");
        Item item3 = new Item();
        item3.setTitle("Item3");
        listView.getItems().addAll(item1, item2, item3);
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            listViewLast = 0;
        });
        listView1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            listViewLast = 1;
        });
        listView.setCellFactory(lv -> {
            ListCell<Item> cell = new ListCell<Item>() {
                @Override
                public void updateItem(Item item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                        setStyle("-fx-background-color: none;");
                    } else {
                        setText(item.getTitle());
                        if(item.getPriority()=="HIGH"){
                            setStyle("-fx-background-color: red;");
                        }else if(item.getPriority()=="MEDIUM"){
                            setStyle("-fx-background-color: yellow;");
                        }else{
                            setStyle("-fx-background-color: green;");
                        }
                        final Tooltip tooltip = new Tooltip();
                        tooltip.setText(item.getDescription());
                        setTooltip(tooltip);
                    }
                }
            };
            return cell ;
        });

        listView1.setCellFactory(lv -> {
            ListCell<Item> cell = new ListCell<Item>() {
                @Override
                public void updateItem(Item item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.getTitle());
                        if(item.getPriority()=="HIGH"){
                            setStyle("-fx-background-color: red;");
                        }else if(item.getPriority()=="MEDIUM"){
                            setStyle("-fx-background-color: yellow;");
                        }else{
                            setStyle("-fx-background-color: green;");
                        }
                    }
                }
            };
            return cell ;
        });

        listView2.setCellFactory(lv -> {
            ListCell<Item> cell = new ListCell<Item>() {
                @Override
                public void updateItem(Item item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.getTitle());
                        if(item.getPriority()=="HIGH"){
                            setStyle("-fx-background-color: red;");
                        }else if(item.getPriority()=="MEDIUM"){
                            setStyle("-fx-background-color: yellow;");
                        }else{
                            setStyle("-fx-background-color: green;");
                        }
                    }
                }
            };
            return cell ;
        });
    }
}
