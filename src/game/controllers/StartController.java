package game.controllers;

import game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.MalformedURLException;


public class StartController {

    @FXML
    private Button btnInit;

    @FXML
    void init(ActionEvent event) {
        Main.setPane(1);
    }

    public StartController() throws MalformedURLException {
    }
}
