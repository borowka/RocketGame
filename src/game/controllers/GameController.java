package game.controllers;

import game.Main;
import game.MovementRunnable;
import game.data.MovementStateHolder;
import game.model.RocketImage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    MovementRunnable movementRunnable;
    MovementStateHolder movementStateHolder = new MovementStateHolder();

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnExit;

    @FXML
    private Button playGameButton;

    @FXML
    private AnchorPane spaceAnimationPane;

    @FXML
    private AnchorPane gameBackgroundPane;

    @FXML
    private AnchorPane statisticsPane;

    @FXML
    private ImageView rocket;

    @FXML
    private Slider propulsivePower;

    @FXML
    private Label fuelBurningLabel;

    @FXML
    private Label propulsivePowerLabel;

    @FXML
    void clickExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void clickMenu(ActionEvent event) {
        Main.setPane(1);
    }

    @FXML
    void playGame(ActionEvent event) {
        //START THEREAT
        //create observer and observable
        //update observers
    }

    @FXML
    void changePropulsivePower(MouseEvent event) {

        new Thread(() -> {
            Platform.runLater(() -> {propulsivePower.setDisable(true);
            System.out.println(propulsivePower.getValue());});

            try {
                Thread.sleep(10000);
            }
            catch(InterruptedException ex) {
                ex.printStackTrace();
            }
            Platform.runLater(() -> propulsivePower.setDisable(false));

        }).start();
        DecimalFormat df = new DecimalFormat("###.###");
        String propulsivePowerValue = df.format(Double.valueOf(propulsivePower.getValue()));
        propulsivePowerLabel.textProperty().set(propulsivePowerValue);

        String fuelBurning = df.format(Double.valueOf(propulsivePower.getValue()*(-16.5)/100));
        fuelBurningLabel.textProperty().set(fuelBurning);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RocketImage.INSTANCE.setImageView(rocket);
        movementStateHolder.clear();
    }
}
