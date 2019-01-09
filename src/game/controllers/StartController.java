package game.controllers;

import game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;

import java.io.File;
import java.net.MalformedURLException;


public class StartController {

    @FXML
    private MediaView movie;

    @FXML
    private TextField userName;

    @FXML
    private Button btnInit;

    @FXML
    void init(ActionEvent event) {
        Main.setPane(1);
    }

    public StartController() throws MalformedURLException {

    }
}
