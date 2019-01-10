package game.calculations;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

import java.io.IOException;
public class Tester {

    private double initHeight = 50000;
    private double initVelocity = -150;
    private double initMass = 2730.14;
    private int groundLevel = 0;
    private int rocketWeight = 1000;

    private double fuelBurning = 0;

    public static void main(String[] args) throws IOException {
        FirstOrderDifferentialEquations differentialEquation = new MovementEquation(0);
        FirstOrderIntegrator integrator = new EulerIntegrator(0.01);
        double[] xStart = new double[]{50000, -150, 2730.14};
        double[] xStop = new double[]{0, -20000, 1000};

        MovementEquationResults movementEquationResults = new MovementEquationResults();
        integrator.addStepHandler(movementEquationResults);
        integrator.integrate(differentialEquation, 0, xStart, 100, xStop );
        String file = "C:\\Users\\asus\\Desktop\\Semestr_V\\Metody_numeryczne\\SpaceshipGame\\date1.txt";
        movementEquationResults.saveTxt(file);
    }
}

