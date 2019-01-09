package game.controllers;

import game.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MenuController {

    @FXML
    private AnchorPane newGamePane;

    @FXML
    private AnchorPane scoresPane;

    @FXML
    private AnchorPane helpPane;

    @FXML
    private Button btnNewGame;

    @FXML
    private Button btnScores;

    @FXML
    private Button btnHelp;

    @FXML
    private Button ctnExit;

    @FXML
    private Button btnPlay;

    @FXML
    void playGame(ActionEvent event) {
        Main.setPane(2);
    }

    @FXML
    void clickExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void clickHelp(ActionEvent event) {
        helpPane.toFront();
    }

    @FXML
    void clickNewGame(ActionEvent event) {
        newGamePane.toFront();
    }

    @FXML
    void clickScores(ActionEvent event) {
        scoresPane.toFront();
    }
}
