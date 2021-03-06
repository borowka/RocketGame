package game.calculations;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

public class MovementEquation implements FirstOrderDifferentialEquations {

    private static final double GASES_VELOCITY = 636;
    private static final double MOON_GRAVITY = 1.63;
    private double fuelBurning = 0;

    public MovementEquation(double fuelBurning) {
        this.fuelBurning = fuelBurning;
    }

    public int getDimension() {
        return 3;
    }

    public void computeDerivatives(double t, double[] x, double[] dxdt) throws MaxCountExceededException, DimensionMismatchException {
        dxdt[0] = x[1];
        dxdt[1] = - MOON_GRAVITY - GASES_VELOCITY * fuelBurning / x[2];
        dxdt[2] = fuelBurning;
    }

}

