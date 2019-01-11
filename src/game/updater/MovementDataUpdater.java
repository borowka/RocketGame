package game.updater;

import game.model.State;
import game.interfaces.Observer;

public class MovementDataUpdater implements Observer {

    private State movementState = new State();

    @Override
    public void update(State state) {
        movementState.setHeight((state.getHeight()));
        movementState.setVelocity(state.getVelocity());
        movementState.setMass(state.getMass());
    }

    public State getMovementState() {
        return movementState;
    }

    public void setMovementState(State movementState) {
        this.movementState = movementState;
    }
}
