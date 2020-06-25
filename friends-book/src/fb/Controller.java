package fb;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    public ListView listView;
    public TextField nameInput;
    public DatePicker birthdateInput;
    public TextField instagramInput;
    public TextField homepageInput;
    public Button saveButton;
    public Button deleteButton;

    public void initialize(){
        listView.getItems().add(new Friend("joe").getName());
        listView.getItems().add("some newer element");
        listView.getItems().add("some newest element");
    }

    public void listClicked(MouseEvent mouseEvent) {
        System.out.println("clicked on " + listView.getSelectionModel().getSelectedIndex());
    }

    public void saveButtonClicked(ActionEvent actionEvent) {

    }

    public void deleteButtonClicked(ActionEvent actionEvent) {
    }
}
