package FractionalKnapsack;

import KnapsackItems.FileReading;
import KnapsackItems.Item;
import KnapsackItems.Knapsack;

public class Main {
    public static void main(String[] args) {
        //display for fractional package
        System.out.println("-------------------------------");
        Knapsack[] bags = FileReading.readAllFiles();
        for (Knapsack sack: bags) {
            displayOneKnapsack(sack);
        }
    }

    public static void displayOneKnapsack(Knapsack knapsack) {
        System.out.printf("Knapsack #%d has a capacity of %d and the following usable items:\n", knapsack.getId(), knapsack.getCapacity());
        for (Item item: knapsack.getItems()) {
            System.out.println(item);
        }

        //brute force (idk what's wrong with it lol)
        long start = System.nanoTime();
        BruteForce b = new BruteForce(knapsack);
        long end = System.nanoTime();
        long time = (end - start) / 1000;
        System.out.printf("Brute Force solution: runtime %d microseconds, max benefit %.2f\n", time, b.solveTheProblem(knapsack));

        start = System.nanoTime();
        Greedy g = new Greedy(knapsack);
        end = System.nanoTime();
        time = (end - start) / 1000;
        System.out.printf("Greedy solution: runtime %d microseconds, max benefit %.2f\n\n", time, g.getValue());

        //no dynamic

    }
}