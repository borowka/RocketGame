package game.controllers;

import game.Main;
import game.model.RocketImage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private RadioButton greyRocket;

    @FXML
    private ToggleGroup buttonGroup;

    @FXML
    private RadioButton whiteRocket;

    @FXML
    private RadioButton blueRocket;

    @FXML
    private AnchorPane newGamePane;

    @FXML
    private AnchorPane helpPane;

    @FXML
    private Button btnNewGame;

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
        helpPane.setVisible(true);
        newGamePane.setVisible(false);
    }

    @FXML
    void clickNewGame(ActionEvent event) {
        newGamePane.toFront();
        newGamePane.setVisible(true);
        helpPane.setVisible(false);
    }

    @FXML
    void whiteSelected(ActionEvent event) throws FileNotFoundException {

        FileInputStream inputstream = new FileInputStream("C:\\Users\\asus\\Desktop\\Semestr_V\\Metody_numeryczne\\SpaceshipGame\\Resources\\rocket2.png");
        Image image = new Image(inputstream);
        RocketImage.INSTANCE.getImageView().setImage(image);
    }

    @FXML
    void greySelected(ActionEvent event) throws FileNotFoundException {
        FileInputStream inputstream = new FileInputStream("C:\\Users\\asus\\Desktop\\Semestr_V\\Metody_numeryczne\\SpaceshipGame\\Resources\\rocket1.png");
        Image image = new Image(inputstream);
        RocketImage.INSTANCE.getImageView().setImage(image);
    }

    @FXML
    void blueSelected(ActionEvent event) throws FileNotFoundException {
        FileInputStream inputstream = new FileInputStream("C:\\Users\\asus\\Desktop\\Semestr_V\\Metody_numeryczne\\SpaceshipGame\\Resources\\rocket3.png");
        Image image = new Image(inputstream);
        RocketImage.INSTANCE.getImageView().setImage(image);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        newGamePane.toFront();
        helpPane.toBack();
    }
}
