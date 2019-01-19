package game;

import game.calculations.RocketMovement;
import game.model.State;
import game.interfaces.Observable;
import game.interfaces.Observer;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MovementRunnable implements Observable, Runnable {

    private static final int ROCKET_MASS = 1000;
    private static final int VELOCITY_MIN = -2;
    private static final int VELOCITY_MAX = 2;
    private static final int INTERVAL = 200;

    private Thread thread;
    protected volatile boolean isRunning = false;
    private double fuelBurning;
    private double height = 50000;
    private double velocity = -150;
    private double mass = 2730.14;
    private double tStart = 0;
    private double tStop = 0.2;
    private double step = 0.2;

    private ImageView winView;
    private ImageView failureView;
    private ImageView flame;
    private Slider slider;

    private volatile List<Observer> observers = new ArrayList<>();
    private State state;

    public MovementRunnable(Slider slider, State state, ImageView winView, ImageView failureView, ImageView flame) {
        this.winView = winView;
        this.failureView = failureView;
        this.flame = flame;
        this.slider = slider;
        this.state = state;
    }

    public void start() {
        thread = new Thread(this, "Movement");
        thread.start();
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObservers(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    public void stop() {
        isRunning = false;
        failureView.setVisible(false);
        flame.setVisible(false);
        winView.setVisible(false);
    }

    @Override
    public void updateObservers() {
        observers.forEach(observer -> observer.update(state));
    }

    @Override
    public void run() {
        isRunning = true;
        RocketMovement rocketMovement = new RocketMovement();
        while (isRunning) {
            try {
                state = rocketMovement.calculateMovementEquation(height, velocity, mass, fuelBurning);
                rocketMovement.settStart(tStart);
                rocketMovement.settStop(tStop);
                tStart += step;
                tStop += step;
                updateObservers();
                height = state.getHeight();
                mass = state.getMass();
                velocity = state.getVelocity();
                double sliderValue = Double.valueOf((slider.getValue() * (-16.5) / 100));
                fuelBurning = sliderValue;

                if (height <= 0) {
                    stop();
                    if (velocity >= VELOCITY_MIN && velocity <= VELOCITY_MAX) {
                        winView.setVisible(true);
                    } else {
                        failureView.setVisible(true);
                        flame.setVisible(true);
                    }
                } else if ((mass - ROCKET_MASS) <= 0) {
                    stop();
                    if (velocity >= VELOCITY_MIN && velocity <= VELOCITY_MAX) {
                        winView.setVisible(true);
                    } else {
                        failureView.setVisible(true);
                    }
                }

                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
