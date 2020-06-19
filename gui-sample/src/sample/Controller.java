package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public TextField txtFieldName;
    public Button btnCancel;
    public Button btnSubmit;
    public Label lblOutput;

    public void cancelName(ActionEvent actionEvent) {
        txtFieldName.setText("");
        lblOutput.setText("???");
    }

    public void submitName(ActionEvent actionEvent) {
        lblOutput.setText(txtFieldName.getText());
    }
}
