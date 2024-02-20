package Knapsack01;

import KnapsackItems.FileReading;
import KnapsackItems.Knapsack;
import org.junit.Test;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Dynamic01UnitTest {

    public ArrayList<Number> testDynamic01Knapsack() {
        Knapsack[] knapsacks = FileReading.readAllFiles();
        Dynamic dynamic = new Dynamic();
        double[] xAxis = new double[6];
        ArrayList<Number> yAxis = new ArrayList<Number>();
        int i = 0;
        for (Knapsack knapsack : knapsacks) {
            long start = System.nanoTime();
            long benefit = dynamic.GetMaxValue(knapsack.getCapacity(), knapsack.getItems());
            long end = System.nanoTime();

            System.out.println("Knapsack " + knapsack.getId() + "\t\t Benefit: " + benefit +
                    "\t\t Items: " + knapsack.getItems().length + "\t\t Time Taken: " + (end - start) / 1000 + " ms");
            xAxis[i] = knapsack.getItems().length;
            yAxis.add(end - start);
            i++;
        }


        return yAxis;
    }

    @Test
    public void showGraph() {
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Dynamic").xAxisTitle("No Of Items").yAxisTitle("Time Taken").theme(Styler.ChartTheme.GGPlot2).build();

        ArrayList<Number> yAxis = testDynamic01Knapsack();
        chart.addSeries("Dynamic Knapsack01", new ArrayList<String>(Arrays.asList(new String[]{"5", "10", "15", "20", "25", "30"})),
                yAxis);

        // Show it
        new SwingWrapper(chart).displayChart();
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
    }
}