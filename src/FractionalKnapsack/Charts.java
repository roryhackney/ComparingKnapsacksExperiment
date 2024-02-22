package FractionalKnapsack;

import Knapsack01.Dynamic;
import KnapsackItems.FileReading;
import KnapsackItems.Knapsack;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.Arrays;


public class Charts {
    /**
     * Displays a graph comparing the performance of Fractional Knapsack algorithms
     */
    public void showGraph(){
        CategoryChart chart = new CategoryChartBuilder().width(1400).height(800).title("Fractional Knapsack Experiment Charts").xAxisTitle("Number Of Items").yAxisTitle("Time Taken").theme(Styler.ChartTheme.GGPlot2).build();
        ArrayList<Number> xAxis = new ArrayList<Number>(Arrays.asList(new Number[] { 5, 10, 15, 20, 25, 30}));
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);

        //Dynamic 01
        ArrayList<Number> yAxis = BruteForceFKnapsack();
        chart.addSeries("Brute Force Fractional * 100" , xAxis, yAxis);

        ArrayList<Number> yAxis1 = GreedyFractionalKnapsack();
        chart.addSeries("Greedy Fractional", xAxis, yAxis1);

        // Show Chart
        new SwingWrapper(chart).displayChart();

    }

    /**
     * Calculates and returns the time taken by Brute Force Programming
     * to solve the knapsack problem
     * @return  an ArrayList containing the time taken for each knapsack
     */
    public ArrayList<Number> BruteForceFKnapsack() {
        // Reads knapsack instances from files
        Knapsack[] knapsacks = FileReading.readAllFiles();
        BruteForce bruteforceF = new BruteForce();
        double[] xAxis = new double[6];
        ArrayList<Number> yAxis = new ArrayList<Number>();
        int i = 0;
        // Calculates time taken for Dynamic 01
        for(Knapsack knapsack : knapsacks) {
            long start = System.nanoTime();
            double benefit = bruteforceF.solveTheProblem(knapsack);
            long end = System.nanoTime();

            System.out.println("Knapsack "+ knapsack.getId() + "\t\t Items: " + knapsack.getItems().length +
                    "\t\t Time Taken: " + (end - start)/1000 + "ms");
            xAxis[i] = knapsack.getItems().length;
            yAxis.add((end - start)/100000);
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
        Greedy greedyF1 = new Greedy(knapsacks[0]);
        int i = 0;
        // Calculates time taken for Greedy Fractional
        for(Knapsack knapsack : knapsacks) {
            long start = System.nanoTime();
            Greedy.solveFractionalKnapsack(knapsack);
            long end = System.nanoTime();

            System.out.println("Knapsack "+ knapsack.getId() + "\t\t Items: " + knapsack.getItems().length +
                    "\t\t Time Taken: " + (end - start)/1000 + "ms");
            xAxis[i] = knapsack.getItems().length;
            yAxis.add((end - start)/1000);
            i++;
        }
        return yAxis;

    }

}
