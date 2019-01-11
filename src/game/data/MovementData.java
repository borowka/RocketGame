package game.data;

import game.interfaces.Observer;

public class MovementData implements Observer {

    private State movementState = new State();
    private double fuelBurning;


    @Override
    public void update(State state) {
        movementState.setHeight((state.getHeight()));
        movementState.setVelocity(state.getVelocity());
        movementState.setMass(state.getMass());
    }

    public double getFuelBurning() {
        return fuelBurning;
    }

    public void setFuelBurning(double fuelBurning) {
        this.fuelBurning = fuelBurning;
    }

    public State getMovementState() {
        return movementState;
    }

    public void setMovementState(State movementState) {
        this.movementState = movementState;
    }
}
