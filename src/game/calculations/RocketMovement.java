package game.calculations;

import game.model.State;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

public class RocketMovement {

    private double tStart = 0;
    private double tStop = 1;


    public State calculateMovementEquation(double height, double velocity, double mass, double fuelBurning) {
        FirstOrderDifferentialEquations differentialEquation = new MovementEquation(fuelBurning);
        //FirstOrderIntegrator integrator = new EulerIntegrator(0.001);
        FirstOrderIntegrator in2 = new ClassicalRungeKuttaIntegrator(0.001);
        double[] xStart = new double[]{height, velocity, mass};
        double[] xStop = new double[]{0, -20000, 1000};
        SimpleResults simpleResults = new SimpleResults();
        in2.addStepHandler(simpleResults);
        in2.integrate(differentialEquation, tStart, xStart, tStop, xStop );

        State state = new State();
        state.setHeight(simpleResults.getHeight());
        state.setVelocity(simpleResults.getVelocity());
        state.setMass(simpleResults.getMass());

        return state;
    }

    public double gettStart() {
        return tStart;
    }

    public void settStart(double tStart) {
        this.tStart = tStart;
    }

    public double gettStop() {
        return tStop;
    }

    public void settStop(double tStop) {
        this.tStop = tStop;
    }


}
