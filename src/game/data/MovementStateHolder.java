package game.data;

import game.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class MovementStateHolder {

    private List<Double> height;
    private List<Double> velocity;
    private List<Double> mass;

    public void clear() {
        height = new ArrayList<>();
        velocity = new ArrayList<>();
        mass = new ArrayList<>();
    }

    public List<Double> getHeight() {
        return height;
    }

    public void setHeight(List<Double> height) {
        this.height = height;
    }

    public List<Double> getVelocity() {
        return velocity;
    }

    public void setVelocity(List<Double> velocity) {
        this.velocity = velocity;
    }

    public List<Double> getMass() {
        return mass;
    }

    public void setMass(List<Double> mass) {
        this.mass = mass;
    }
}
