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
    public void showGraph(){
        CategoryChart chart = new CategoryChartBuilder().width(1400).height(800).title("Knapsack Experiment Charts").xAxisTitle("Number Of Items").yAxisTitle("Time Taken").theme(Styler.ChartTheme.GGPlot2).build();
        ArrayList<Number> xAxis = new ArrayList<Number>(Arrays.asList(new Number[] { 5, 10, 15, 20, 25, 30}));

        //Dynamic 01
        ArrayList<Number> yAxis = Dynamic01Knapsack();
        chart.addSeries("Dynamic01" , xAxis, yAxis);

        ArrayList<Number> yAxis1 = GreedyFractionalKnapsack();
        chart.addSeries("Greedy Fractional", xAxis, yAxis1);

        /*
        //ArrayList<Number> yAxis1 = Greedy01Knapsack();
        chart.addSeries("Greedy 01", xAxis, yAxis1);

        //ArrayList<Number> yAxis1 = BruteForceFractionalKnapsack();
        chart.addSeries("Brute Force Fractional", xAxis, yAxis1);

        //ArrayList<Number> yAxis1 = BruteForce01Knapsack();
        chart.addSeries("Brute Force 01", xAxis, yAxis1);
        */


        // Show Chart
        new SwingWrapper(chart).displayChart();

    }

    /**
     * Calculates and returns the time taken by Dynamic Programming
     * to solve the knapsack problem
     * @return  an ArrayList containing the time taken for each knapsack
     */
    public ArrayList<Number> Dynamic01Knapsack() {
        // Reads knapsack instances from files
        Knapsack[] knapsacks = FileReading.readAllFiles();
        Dynamic dynamic = new Dynamic();
        double[] xAxis = new double[6];
        ArrayList<Number> yAxis = new ArrayList<Number>();
        int i = 0;
        // Calculates time taken for Dynamic 01
        for(Knapsack knapsack : knapsacks) {
            long start = System.nanoTime();
            long benefit = dynamic.GetMaxValue(knapsack.getCapacity(), knapsack.getItems());
            long end = System.nanoTime();

            System.out.println("Knapsack "+ knapsack.getId() + "\t\t Benefit: " + benefit +
                    "\t\t Items: " + knapsack.getItems().length + "\t\t Time Taken: " + (end - start)/1000 + " ms");
            xAxis[i] = knapsack.getItems().length;
            yAxis.add((end - start)/1000);
            i++;
        }
        return yAxis;
    }

    /**
     * Calculates and returns the time taken by Greedy Programming
     * to solve the knapsack problem
     * @return an ArrayList containing the time taken for each knapsack
     */
    public ArrayList<Number> GreedyFractionalKnapsack() {
        // Reads knapsack instances from files
        Knapsack[] knapsacks = FileReading.readAllFiles();

        double[] xAxis = new double[6];
        ArrayList<Number> yAxis = new ArrayList<Number>();
        // Constructor is doing knapsack calculation, first time run will take time.
        FractionalKnapsack.Greedy greedyF1 = new FractionalKnapsack.Greedy(knapsacks[0]);
        int i = 0;
        // Calculates time taken for Greedy Fractional
        for(Knapsack knapsack : knapsacks) {
            long start = System.nanoTime();
            FractionalKnapsack.Greedy greedyF = new FractionalKnapsack.Greedy(knapsack);
            double benefit = greedyF.getValue();
            long end = System.nanoTime();

            System.out.println("Knapsack "+ knapsack.getId() + "\t\t Benefit: " + benefit +
                    "\t\t Items: " + knapsack.getItems().length + "\t\t Time Taken: " + (end - start));
            xAxis[i] = knapsack.getItems().length;
            yAxis.add((end - start)/1000);
            i++;
        }
        return yAxis;

    }

}
