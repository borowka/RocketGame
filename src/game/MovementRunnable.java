package game;

import game.calculations.RocketMovement;
import game.data.State;
import game.interfaces.Observable;
import game.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class MovementRunnable implements Observable, Runnable {

    private Thread thread;
    protected volatile boolean isRunning = false;
    protected volatile boolean isPaused = false;
    private double fuelBurning;
    private double height = 50000 ;
    private double velocity = -150;
    private double mass = 2730.14;
    private double tStart = 0;
    private double tStop = 1;

    private volatile List<Observer> observers = new ArrayList<>();

    private State state;

    public MovementRunnable(double fuelBurning, State state) {
        this.fuelBurning = fuelBurning;
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

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
