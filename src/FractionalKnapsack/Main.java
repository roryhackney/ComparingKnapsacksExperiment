package FractionalKnapsack;

import KnapsackItems.FileReading;
import KnapsackItems.Item;
import KnapsackItems.Knapsack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Charts chart = new Charts();
        chart.showGraph();

        Knapsack bag = new Knapsack(1, 5, new Item[]{new Item(3, 3), new Item(2, 2), new Item(1, 1)});
        bag = KnapsackItems.FileReading.readFile("inputs.csv");
        BruteForce x = new BruteForce(bag);
        System.out.println(bag.getCapacity());
        System.out.println(Arrays.toString(bag.getItems()));
        System.out.println(x.getMaxBenefit());
        System.out.println(x.getFinalItems());

        //Greedy gets different results
        System.out.println(Greedy.solveFractionalKnapsack(bag));

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
        System.out.printf("Brute Force solution: runtime %d microseconds, max benefit %.2f, using items\n", time, b.getMaxBenefit());
        System.out.println(b.getFinalItems());

        start = System.nanoTime();
        Greedy g = new Greedy(knapsack);
        end = System.nanoTime();
        time = (end - start) / 1000;
        System.out.printf("Greedy solution: runtime %d microseconds, max benefit %.2f\n\n", time, g.getValue());

        //no dynamic

    }
}
