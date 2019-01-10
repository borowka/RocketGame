package game;

import game.calculations.RocketMovement;
import game.data.MovementStateHolder;
import game.interfaces.Observable;
import game.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class MovementRunnable implements Observable, Runnable {

    private Thread thread;
    protected volatile boolean isRunning = false;
    protected volatile boolean isPaused = false;
    private static final int INTERVAL = 60000;
    private MovementStateHolder movementStateHolder;
    private double fuelBurning = 0;
    private double height = 50000 ;
    private double velocity = -150;
    private double mass = 2730.14;
    private volatile List<Observer> observers = new ArrayList<>();

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
        observers.forEach(observer -> observer.update(movementStateHolder));
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
                movementStateHolder = rocketMovement.calculateMovementEquation(height, velocity, mass, fuelBurning);
                updateObservers();
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
