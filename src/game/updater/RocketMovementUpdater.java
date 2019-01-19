package game.updater;

import game.interfaces.Observer;
import game.model.State;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class RocketMovementUpdater implements Observer {

    TranslateTransition translateTransition = new TranslateTransition();
    private ImageView rocket;
    public RocketMovementUpdater(ImageView rocket) {
        this.rocket = rocket;
    }

    @Override
    public void update(State state) {
        Platform.runLater(()->{
            double height = -state.getHeight();
            height = height/167 + 120;
            rocket.setY(height);
        });
    }
}
