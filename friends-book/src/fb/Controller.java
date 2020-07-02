package fb;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Controller {
    public ListView listView;
    public TextField nameInput;
    public DatePicker birthdateInput;
    public TextField instagramInput;
    public TextField homepageInput;
    public Button saveButton;
    public Button deleteButton;
    public Button addButton;
    public Button open;
    public TextField fileNameInput;
    public VBox listContainer;
    public Label fileIndicator;

    // name of working file
    String workingFile = "friends.txt";

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
        birthdateInput.setValue(data.getBirthDate());
        instagramInput.setText(data.getInstagramHandle());
        homepageInput.setText(data.getHomepageURL());
    }

    public void clearForm() {
        nameInput.setText("");
        birthdateInput.setValue(LocalDate.now());
        instagramInput.setText("");
        homepageInput.setText("");
    }

    public Friend friendFromForm() {
        return new Friend(
                nameInput.getText(),
                birthdateInput.getValue(), // DATE
                instagramInput.getText(),
                homepageInput.getText()
        );
    }

    /* EVENTS */
    public void initialize() throws IOException {
        fileIndicator.setText("Current File: " + workingFile);

        // create new file if it does not exist
        File file = new File(workingFile);
        file.createNewFile();

        book = Book.fromFile(workingFile);
        renderBook();
    }

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

    public void saveButtonClicked(ActionEvent actionEvent) throws IOException {
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

            book.toFile(workingFile);
        }
    }

    public void deleteButtonClicked(ActionEvent actionEvent) throws IOException {
        if (selectedIndex != -2) {
            book.remove(book.getItem(selectedIndex));
            selectedIndex = -1;

            clearForm();

            formContainer.setVisible(false);
            addButton.setDisable(false);
            deleteButton.setDisable(true);

            renderBook();
            book.toFile(workingFile);
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

    public void openButtonClicked(ActionEvent actionEvent) throws IOException {
        if (!fileNameInput.getText().equals("")) {
            workingFile = fileNameInput.getText();
            fileIndicator.setText("Current File: " + workingFile);
            fileNameInput.setText("");

            formContainer.setVisible(false);
            addButton.setDisable(false);

            // create new file if it does not exist
            File file = new File(workingFile);
            file.createNewFile();

            book = Book.fromFile(workingFile);
            renderBook();
        }
    }
}
