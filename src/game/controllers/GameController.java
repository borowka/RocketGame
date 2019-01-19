package game.controllers;

import game.Main;
import game.MovementRunnable;
import game.updater.LabelUpdater;
import game.updater.MovementDataUpdater;
import game.model.State;
import game.model.RocketImage;
import game.updater.ChartUpdater;
import game.updater.RocketMovementUpdater;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    MovementRunnable movementRunnable;
    MovementDataUpdater movementDataUpdater = new MovementDataUpdater();
    TranslateTransition translateTransition = new TranslateTransition();

    @FXML
    private ImageView winView;

    @FXML
    private ImageView failureView;

    @FXML
    private ImageView flameView;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnExit;

    @FXML
    private Button playGameButton;

    @FXML
    private AnchorPane spaceAnimationPane;

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
    private Label velocityLabel;

    @FXML
    private Label heightLabel;

    @FXML
    private Label massLabel;

    @FXML
    private Label fuelLevelLabel;

    @FXML
    private ScatterChart<Number, Number> phaseChart;

    @FXML
    private NumberAxis vAxis;

    @FXML
    private NumberAxis hAxis;

    @FXML
    void clickExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void clickMenu(ActionEvent event) {
        Main.setPane(1);
        movementRunnable.stop();
    }

    @FXML
    void playGame(ActionEvent event) {
        phaseChart.getData().clear();
        double fuelBurning = propulsivePower.getValue() * (-16.5) / 100;
        State state = movementDataUpdater.getMovementState();
        movementRunnable = new MovementRunnable(propulsivePower, state, winView, failureView, flameView);
        ChartUpdater chartUpdater = new ChartUpdater(vAxis, hAxis, phaseChart);
        LabelUpdater labelUpdater = new LabelUpdater(heightLabel, velocityLabel, fuelLevelLabel, massLabel);
        translateTransition.setNode(rocket);
        RocketMovementUpdater rocketMovementUpdater = new RocketMovementUpdater(rocket);
        movementRunnable.addObserver(rocketMovementUpdater);
        movementRunnable.addObserver(labelUpdater);
        movementRunnable.addObserver(movementDataUpdater);
        movementRunnable.addObserver(chartUpdater);
        movementRunnable.start();
    }

    @FXML
    void changePropulsivePower(MouseEvent event) {

        new Thread(() -> {
            Platform.runLater(() -> {
                propulsivePower.setDisable(true);
                System.out.println(propulsivePower.getValue());
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            Platform.runLater(() -> propulsivePower.setDisable(false));

        }).start();
        DecimalFormat df = new DecimalFormat("###.###");
        String propulsivePowerValue = df.format(Double.valueOf(propulsivePower.getValue()));
        propulsivePowerLabel.textProperty().set(propulsivePowerValue);

        String fuelBurning = df.format(Double.valueOf(propulsivePower.getValue() * (-16.5) / 100));
        fuelBurningLabel.textProperty().set(fuelBurning);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RocketImage.INSTANCE.setImageView(rocket);
        rocket.setY(-178);
        rocket.setX(-10);
    }
}
