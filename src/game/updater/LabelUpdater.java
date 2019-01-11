package game.updater;

import game.model.State;
import game.interfaces.Observer;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.text.DecimalFormat;

public class LabelUpdater implements Observer {


    private Label heightLabel;
    private Label velocityLabel;
    private Label fuelLabel;
    private Label massLabel;
    private static final double ROCKET_MASS = 1000;

    public LabelUpdater(Label heightLabel, Label velocityLabel, Label fuelLabel, Label massLabel) {
        this.heightLabel = heightLabel;
        this.velocityLabel = velocityLabel;
        this.fuelLabel = fuelLabel;
        this.massLabel = massLabel;
    }

    @Override
    public void update(State state) {
        Platform.runLater(()->{
            DecimalFormat df = new DecimalFormat("##.###");
            String height = df.format(Double.valueOf(state.getHeight()));
            heightLabel.textProperty().set(height);
            String velocity = df.format(Double.valueOf(state.getVelocity()));
            velocityLabel.textProperty().set(velocity);
            String mass = df.format(Double.valueOf(state.getMass()));
            massLabel.textProperty().set(mass);
            double fuelLevel = state.getMass() - ROCKET_MASS;
            String fuelLevelString =  df.format(Double.valueOf(fuelLevel));
            fuelLabel.textProperty().set(fuelLevelString);

        });
    }
}
