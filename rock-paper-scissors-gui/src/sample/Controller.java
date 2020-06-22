package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Controller {

    public Label result;
    public Label yourScore;
    public RadioButton rockButton;
    public RadioButton paperButton;
    public RadioButton scissorsButton;
    public Label machineScore;
    public Label machineChoice;
    public Button play;

    String[] choices = {"rock", "paper", "scissors"};
    int userScore = 0;
    int botScore = 0;

    String bot;
    String user;

    private void playGame() {
        // make bot choice
        bot = choices[(int) (Math.random() * 3)];
        machineChoice.setText(bot);

        // play
        // note: code easier to read when strings are used, instead of array reference
        Boolean winningCondition =
                user.equals("paper") && bot.equals("rock") ||
                        user.equals("scissors") && bot.equals("paper") ||
                        user.equals("rock") && bot.equals("scissors");

        if (user.equals(bot)) {
            result.setText("Draw!");
        } else if (winningCondition) {
            userScore++;
            result.setText("You Win!");
        } else {
            botScore++;
            result.setText("You Lose!");
        }
    }

    private void uiAgain() {
        play.setText("Play");
        result.setText("Play Again");

        machineChoice.setText("");

        rockButton.setDisable(false);
        paperButton.setDisable(false);
        scissorsButton.setDisable(false);

        rockButton.setSelected(false);
        paperButton.setSelected(false);
        scissorsButton.setSelected(false);

        play.setDisable(true);
    }

    private void uiAfterPlay() {
        play.setText("Again?");

        yourScore.setText("You: " + String.valueOf(userScore));
        machineScore.setText("Machine: " + String.valueOf(botScore));
    }


    private void uiAfterChoice() {
        rockButton.setDisable(true);
        paperButton.setDisable(true);
        scissorsButton.setDisable(true);

        play.setDisable(false);
    }

    public void choseRock(ActionEvent actionEvent) {
        user = choices[0];
        uiAfterChoice();
    }

    public void chosePaper(ActionEvent actionEvent) {
        user = choices[1];
        uiAfterChoice();
    }

    public void choseScissors(ActionEvent actionEvent) {
        user = choices[2];
        uiAfterChoice();
    }

    public void play(ActionEvent actionEvent) {
        if (this.play.getText().equals("Play")) {
            playGame();
            uiAfterPlay();
        } else {
            uiAgain();
        };
    }
}
