package game.calculations;

import game.data.MovementStateHolder;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

public class RocketMovement {

    public MovementStateHolder calculateMovementEquation(double height, double velocity, double mass, double fuelBurning) {
        FirstOrderDifferentialEquations differentialEquation = new MovementEquation(fuelBurning);
        FirstOrderIntegrator integrator = new EulerIntegrator(0.01);
        double[] xStart = new double[]{height, velocity, mass};
        double[] xStop = new double[]{0, -20000, 1000};

        MovementEquationResults movementEquationResults = new MovementEquationResults();
        integrator.addStepHandler(movementEquationResults);
        integrator.integrate(differentialEquation, 0, xStart, 10, xStop );

        MovementStateHolder movementStateHolder = new MovementStateHolder();
        movementStateHolder.setHeight(movementEquationResults.gethList());
        movementStateHolder.setVelocity(movementEquationResults.getvList());
        movementStateHolder.setMass(movementEquationResults.getmList());

        return movementStateHolder;
    }
}
