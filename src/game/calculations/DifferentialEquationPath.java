package game.calculations;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferentialEquationPath implements StepHandler {
    private List<Double> tList = new ArrayList<>();
    private List<Double> hList = new ArrayList<>();
    private List<Double> vList = new ArrayList<>();
    private List<Double> mList = new ArrayList<>();

    @Override
    public void init(double v, double[] doubles, double v1) {
    }

    public void handleStep(StepInterpolator stepInterpolator, boolean b)
            throws MaxCountExceededException {
        double t = stepInterpolator.getCurrentTime();
        double[] x = stepInterpolator.getInterpolatedState();
        tList.add(t);
        hList.add(x[0]);
        vList.add(x[1]);
        mList.add(x[2]);
        System.out.println(" t = " + t + " " + Arrays.toString(x));
    }


    public void saveTxt(String filePath) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            //DecimalFormat df = new DecimalFormat("0.00");
            for (int i = 0; i < hList.size(); i++) {
                fileWriter.write(String.format("%s\t",
                        (hList.get(i)).toString()));
                fileWriter.write(String.format("%s\t",
                        (vList.get(i))));
                fileWriter.write(String.format("%s\t",
                        (mList.get(i))));
                fileWriter.write(String.format("%s\n",
                        (tList.get(i))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}

