package game.test;

import game.calculations.MovementEquation;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

import java.io.IOException;
public class Tester {

    public static void main(String[] args) throws IOException {
        FirstOrderDifferentialEquations differentialEquation = new MovementEquation(0);
        FirstOrderIntegrator integrator = new EulerIntegrator(0.1);
        double[] xStart = new double[]{50000, -150, 2730.14};
        double[] xStop = new double[]{0, -20000, 1000};

        MovementEquationResults movementEquationResults = new MovementEquationResults();
        integrator.addStepHandler(movementEquationResults);
        integrator.integrate(differentialEquation, 0, xStart, 180, xStop );
        String file = "C:\\Users\\asus\\Desktop\\Semestr_V\\Metody_numeryczne\\SpaceshipGame\\date1.txt";
        movementEquationResults.saveTxt(file);
    }
}

