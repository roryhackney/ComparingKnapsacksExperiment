package Knapsack01;

import KnapsackItems.FileReading;
import KnapsackItems.Item;
import KnapsackItems.Knapsack;

/**
 * Main Class to run algorithms for the 01 Knapsack Problem
 *
 * @author KRB
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //display for 01 package
        System.out.println("-------------------------------");
        Knapsack[] bags = FileReading.readAllFiles();
        displayOneKnapsack(bags[0]);
//        for (Knapsack sack: bags) {
//            displayOneKnapsack(sack);
//        }
    }

    public static void displayOneKnapsack(Knapsack knapsack) {
        System.out.printf("Knapsack #%d has a capacity of %d and the following usable items:\n", knapsack.getId(), knapsack.getCapacity());
        for (Item item: knapsack.getItems()) {
            System.out.println(item);
        }

        long start = System.nanoTime();
        Knapsack01.BruteForce b = new BruteForce(knapsack);
        long end = System.nanoTime();
        long time = (end - start) / 1000;
        System.out.printf("Brute Force solution: runtime %d microseconds, max benefit %d\n", time, b.getBestBenefit());

        start = System.nanoTime();
        Knapsack01.Greedy g = new Greedy(knapsack);
        end = System.nanoTime();
        time = (end - start) / 1000;
        System.out.printf("Greedy solution: runtime %d microseconds, max benefit %d\n\n", time, g.getBestBenefit());

        start = System.nanoTime();
        Knapsack01.Dynamic d = new Dynamic();
        float benefits = (float)d.GetMaxValue(knapsack);
        end = System.nanoTime();
        time = (end - start) / 1000;
        System.out.printf("Dynamic solution: runtime %d microseconds, max benefit %.2f\n\n", time, benefits);

    }
}
