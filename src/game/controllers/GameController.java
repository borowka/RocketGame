package game.controllers;

import game.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class GameController {

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnRestart;

    @FXML
    private Button btnPause;

    @FXML
    private Button btnExit;

    @FXML
    private AnchorPane spaceAnimationPane;

    @FXML
    private AnchorPane gameBackgroundPane;

    @FXML
    private ImageView rocket;

    @FXML
    private AnchorPane statisticsPane;

    @FXML
    void clickExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void clickMenu(ActionEvent event) {
        Main.setPane(1);
    }

    @FXML
    void clickPause(ActionEvent event) throws InterruptedException {
    }

    @FXML
    void clickRestart(ActionEvent event) {

    }

}
