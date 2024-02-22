package Charts;

import Knapsack01.Dynamic;
import KnapsackItems.FileReading;
import KnapsackItems.Knapsack;
import org.junit.Test;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Charts {
    /**
     * Displays a graph comparing the performance of 5 knapsack algorithms
     */
    public void showGraph() {
        CategoryChart chart = new CategoryChartBuilder().width(1400).height(800).title("All Knapsack Algorithm Experiment Charts").xAxisTitle("Number Of Items").yAxisTitle("Time Taken").theme(Styler.ChartTheme.GGPlot2).build();
        ArrayList<Number> xAxis = new ArrayList<Number>(Arrays.asList(new Number[]{5, 10, 15, 20, 25, 30}));

        FractionalKnapsack.Charts fractionalChart = new FractionalKnapsack.Charts();
        Knapsack01.Charts knapsack01Chart = new Knapsack01.Charts();

        ArrayList<Number> yAxis = knapsack01Chart.Dynamic01Knapsack();
        chart.addSeries("Dynamic01", xAxis, yAxis);

        ArrayList<Number> yAxis2 = knapsack01Chart.Greedy01Knapsack();
        chart.addSeries("Greedy 01", xAxis, yAxis2);

        ArrayList<Number> yAxis4 = knapsack01Chart.BruteForce01Knapsack();
        chart.addSeries("Brute Force 01 * 100", xAxis, yAxis4);

        ArrayList<Number> yAxis1 = fractionalChart.GreedyFractionalKnapsack();
        chart.addSeries("Greedy Fractional", xAxis, yAxis1);

        ArrayList<Number> yAxis3 = fractionalChart.BruteForceFKnapsack();
        chart.addSeries("Brute Force Fractional * 100", xAxis, yAxis3);


        // Show Chart
        new SwingWrapper(chart).displayChart();

    }
}
