package game.calculations;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;
import org.apache.commons.math3.ode.nonstiff.RungeKuttaIntegrator;

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
        double[] xStop = new double[]{0, 1, 1000};

        DifferentialEquationPath differentialEquationPath = new DifferentialEquationPath();
        integrator.addStepHandler(differentialEquationPath);
        integrator.integrate(differentialEquation, 0, xStart, 10, xStop );
        String file = "C:\\Users\\asus\\Desktop\\Semestr_V\\Metody_numeryczne\\SpaceshipGame\\date1.txt";
        differentialEquationPath.saveTxt(file);
    }
}

