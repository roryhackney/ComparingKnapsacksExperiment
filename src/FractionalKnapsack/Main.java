package FractionalKnapsack;

import KnapsackItems.Item;
import KnapsackItems.Knapsack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Charts chart = new Charts();
        chart.showGraph();


        BruteForce x = new BruteForce();
        Knapsack bag = new Knapsack(1, 5, new Item[]{new Item(3, 3), new Item(2, 2), new Item(1, 1)});
        bag = KnapsackItems.FileReading.readFile("inputs5.csv");
        System.out.println(bag.getCapacity());
        System.out.println(Arrays.toString(bag.getItems()));
        double res = x.solveTheProblem(bag);
        System.out.println(res);
        System.out.println(x.getFinalItems());

        //Greedy gets different results
        System.out.println(Greedy.solveFractionalKnapsack(bag));
    }

}
