package game.calculations;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

import java.util.Arrays;

public class SimpleResults implements StepHandler {
    private double time;
    private double height;
    private double velocity;
    private double mass;

    @Override
    public void init(double v, double[] doubles, double v1) {
    }

    public void handleStep(StepInterpolator stepInterpolator, boolean b) throws MaxCountExceededException {
        double t = stepInterpolator.getCurrentTime();
        double[] x = stepInterpolator.getInterpolatedState();
        time = t;
        height = x[0];
        velocity = x[1];
        mass = x[2];
        //System.out.println(" t = " + t + " " + Arrays.toString(x));
    }

    public double getHeight() {
        return height;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getMass() {
        return mass;
    }

}

