package game.controllers;

import game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;

import java.net.MalformedURLException;


public class StartController {

    @FXML
    private ImageView view;

    @FXML
    private TextField userName;

    @FXML
    private Button btnInit;

    @FXML
    private MediaView media;

    @FXML
    void init(ActionEvent event) {
        Main.setPane(1);
    }

    public StartController() throws MalformedURLException {

    }
}
