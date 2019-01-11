package game;

import game.calculations.RocketMovement;
import game.model.State;
import game.interfaces.Observable;
import game.interfaces.Observer;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.util.ArrayList;
import java.util.List;

public class MovementRunnable implements Observable, Runnable {

    private Thread thread;
    protected volatile boolean isRunning = false;
    protected volatile boolean isPaused = false;
    private double fuelBurning;
    private double height = 50000 ;
    private double velocity = -150;
    private double tStart = 0;
    private double tStop = 1;
    private double mass = 2730.14;

    private Slider slider;
    private Label massLabel;

    private volatile List<Observer> observers = new ArrayList<>();

    private State state;

    public MovementRunnable(Slider slider, State state) {
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
                synchronized (this) {
                    if (isPaused) {
                        this.wait();
                    }
                }

                state = rocketMovement.calculateMovementEquation(height, velocity, mass, fuelBurning);
                rocketMovement.settStart(tStart);
                rocketMovement.settStop(tStop);
                tStart += 1;
                tStop += 1;
                updateObservers();
                height = state.getHeight();
                mass = state.getMass();
                velocity = state.getVelocity();
                double sliderValue = Double.valueOf((slider.getValue()*(-16.5)/100));
                System.out.println(sliderValue);
                fuelBurning = sliderValue;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public double getFuelBurning() {
        return fuelBurning;
    }

    public void setFuelBurning(double fuelBurning) {
        this.fuelBurning = fuelBurning;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

}
