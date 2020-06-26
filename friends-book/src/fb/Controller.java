package fb;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.Date;

public class Controller {
    public ListView listView;
    public TextField nameInput;
    public DatePicker birthdateInput;
    public TextField instagramInput;
    public TextField homepageInput;
    public Button saveButton;
    public Button deleteButton;
    public Button addButton;

    // book to store our friends
    public Book book = new Book();

    /*
        NOTE: -1 is no item selected,
        -2 is new item,
        and bigger than -1 is an item on the list
    */
    public int selectedIndex = -1;
    public VBox formContainer;

    public int suggestedId = book.getList().size() + 1;

    /* METHODS */
    // renders the book onto the list
    public void renderBook() {
        listView.getItems().clear();

        for(int i = 0; i < book.getList().size(); i += 1) {
            listView.getItems().add(book.getItem(i).getName());
        }

        listView.getSelectionModel().select(selectedIndex);
        listView.scrollTo(selectedIndex);
    }


    public void updateForm(Friend data) {
        nameInput.setText(data.getName());
        // DATE
        instagramInput.setText(data.getInstagramHandle());
        homepageInput.setText(data.getHomepageURL());
    }

    public void clearForm() {
        nameInput.setText("");
        // DATE
        instagramInput.setText("");
        homepageInput.setText("");
    }

    public Friend friendFromForm() {
        return new Friend(
                nameInput.getText(),
                new Date(), // DATE
                instagramInput.getText(),
                homepageInput.getText()
        );
    }

    /* EVENTS */
    public void listClicked(MouseEvent mouseEvent) {
        if (selectedIndex == -2) {
            clearForm();

            formContainer.setVisible(false);
            addButton.setDisable(false);
            deleteButton.setDisable(true);
        }

        // update selected index to item on list
        // will be -1 if no selection (empty list)
        selectedIndex = listView.getSelectionModel().getSelectedIndex();

        if (selectedIndex != -1) {
            Friend data = book.getItem(selectedIndex);
            updateForm(data);

            formContainer.setVisible(true);
            addButton.setDisable(false);
            deleteButton.setDisable(false);
        }
    }

    public void saveButtonClicked(ActionEvent actionEvent) {
        suggestedId++;

        // only if name has been filled out
        if(!nameInput.getText().equals("")) {
            Friend friend = friendFromForm();

            if (selectedIndex == -2) {
                // new friend
                book.add(friend);
                selectedIndex = book.getList().size() - 1;
            } else if (selectedIndex != -1){
                // edited friend
                book.setItem(selectedIndex, friend);
            }

            formContainer.setVisible(true);
            addButton.setDisable(false);
            deleteButton.setDisable(false);

            renderBook();
        }
    }

    public void deleteButtonClicked(ActionEvent actionEvent) {
        if (selectedIndex != -2) {
            book.remove(book.getItem(selectedIndex));
            selectedIndex = -1;

            clearForm();

            formContainer.setVisible(false);
            addButton.setDisable(false);
            deleteButton.setDisable(true);

            renderBook();
        }
    }

    public void addButtonClicked(ActionEvent actionEvent) {
        clearForm();

        nameInput.setText("New Friend " + suggestedId);
        selectedIndex = -2; // creation state

        formContainer.setVisible(true);
        addButton.setDisable(true);
        deleteButton.setDisable(true);
    }
}
