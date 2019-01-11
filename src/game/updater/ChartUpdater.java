package game.updater;

import game.model.State;
import game.interfaces.Observer;
import javafx.application.Platform;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class ChartUpdater implements Observer {

    private NumberAxis vAxis;
    private NumberAxis hAxis;
    private ScatterChart<Number, Number> phaseChart;
    private List<Double> vList = new ArrayList<>();
    private List<Double> hList = new ArrayList<>();


    public ChartUpdater(NumberAxis vAxis, NumberAxis hAxis, ScatterChart<Number, Number> phaseChart) {
        this.vAxis = vAxis;
        this.hAxis = hAxis;
        this.phaseChart = phaseChart;
    }

    @Override
    public void update(State state) {
        Platform.runLater(()->{
            phaseChart.getData().clear();
            XYChart.Series phaseSeries = new XYChart.Series();
            double height = state.getHeight();
            double velocity = state.getVelocity();

            hList.add(height);
            vList.add(velocity);

            for (int i = 0; i < hList.size(); i++) {
                phaseSeries.getData().add(new XYChart.Data(vList.get(i), hList.get(i)));
            }
            phaseChart.getData().addAll(phaseSeries);
        });
    }
}
