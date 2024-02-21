package Knapsack01;

import KnapsackItems.FileReading;
import KnapsackItems.Knapsack;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.internal.chartpart.Annotation;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Charts {
    /**
     * Displays a graph comparing the performance of knapsack01 algorithms
     */
    public void showGraph(){
        CategoryChart chart = new CategoryChartBuilder().width(1400).height(800).title("Knapsack01 Experiment Charts").xAxisTitle("Number Of Items").yAxisTitle("Time Taken").build();
        ArrayList<Number> xAxis = new ArrayList<Number>(Arrays.asList(new Number[] { 5, 10, 15, 20, 25, 30}));
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);

        //Dynamic 01
        ArrayList<Number> yAxis = Dynamic01Knapsack();
        chart.addSeries("Dynamic 01" , xAxis, yAxis);

        ArrayList<Number> yAxis1 = Greedy01Knapsack();
        chart.addSeries("Greedy 01", xAxis, yAxis1);

        ArrayList<Number> yAxis2 = BruteForce01Knapsack();
        chart.addSeries("Brute Force 01 * 1000", xAxis, yAxis2);

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
            long benefit = dynamic.GetMaxValue(knapsack);
            long end = System.nanoTime();

            System.out.println("Knapsack "+ knapsack.getId() + "\t\t Benefit: " + benefit +
                    "\t\t Items: " + knapsack.getItems().length + "\t\t Time Taken: " + + (end - start) + " ns");
            xAxis[i] = knapsack.getItems().length;
            yAxis.add(end - start);
            i++;
        }
        return yAxis;
    }
    public ArrayList<Number> BruteForce01Knapsack() {
        // Reads knapsack instances from files
        Knapsack[] knapsacks = FileReading.readAllFiles();

        double[] xAxis = new double[6];
        ArrayList<Number> yAxis = new ArrayList<Number>();
        BruteForce bruteForce01 = new BruteForce(knapsacks[0]);
        int i = 0;
        // Calculates time taken for Brute Force 01
        for(Knapsack knapsack : knapsacks) {
            long start = System.nanoTime();
            BruteForce bruteForce = new BruteForce(knapsack);
            long end = System.nanoTime();

            System.out.println("Knapsack "+ knapsack.getId() + "\t\t Benefit: " +
                    "\t\t Items: " + knapsack.getItems().length + "\t\t Time Taken: " + + (end - start)/1000 + " ns");
            xAxis[i] = knapsack.getItems().length;
            yAxis.add((end - start)/1000);
            i++;
        }
        return yAxis;
    }
    /**
     * Calculates and returns the time taken by Greedy Knapsack01 Programming
     * to solve the knapsack problem
     * @return an ArrayList containing the time taken for each knapsack
     */
    public ArrayList<Number> Greedy01Knapsack() {
        // Reads knapsack instances from files
        Knapsack[] knapsacks = FileReading.readAllFiles();

        double[] xAxis = new double[6];
        ArrayList<Number> yAxis = new ArrayList<Number>();
        Greedy greedyF1 = new Greedy(knapsacks[0]);
        int i = 0;
        // Calculates time taken for Greedy 01
        for(Knapsack knapsack : knapsacks) {
            long start = System.nanoTime();
            Greedy greedyF = new Greedy(knapsack);
            long end = System.nanoTime();

            System.out.println("Knapsack "+ knapsack.getId() + "\t\t Benefit: " +
                    "\t\t Items: " + knapsack.getItems().length + "\t\t Time Taken: " + (end - start) + " ns");
            xAxis[i] = knapsack.getItems().length;
            yAxis.add(end - start);
            i++;
        }
        return yAxis;
    }
}
