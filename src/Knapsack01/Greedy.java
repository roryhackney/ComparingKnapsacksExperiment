package Knapsack01;

import KnapsackItems.Item;
import KnapsackItems.Knapsack;

import java.util.*;

/**
 * Class implementation for Greedy Algo on a KnapSack 01 Problem
 *
 * @author KRB
 * @version 1.0
 */
public class Greedy {
    /**
     * Constructor for Greedy Algorithm
     * @param knapsack Desired Knapsack to run algorithm through
     */
    public Greedy(Knapsack knapsack) {
        Item[] items = knapsack.getItems();
        int cap = knapsack.getCapacity();

        int totalLoad = 0;
        int totalBenefit = 0;
        List<Item> combo = new ArrayList<>();

//        List<Double> ratios = new ArrayList<>();
//        for (Item item : items) {
//            double ratio = (double)item.getBenefit() / item.getWeight();
//            ratios.add(ratio);
//        }

        Item[] sortedItems = Arrays.copyOf(items, items.length);
        Arrays.sort(sortedItems, Comparator.comparingDouble((Item item) -> (double)item.getBenefit() / item.getWeight()).reversed());

        for (Item item : sortedItems) {
            if (totalLoad + item.getWeight() <= cap) {
                totalLoad += item.getWeight();
                totalBenefit += item.getBenefit();
                combo.add(item);
            } else {
                break;
            }
        }
        System.out.println("This is Knapsack number - " + knapsack.getId() + ".");
        System.out.println("The knapsack's capacity is - " + cap + ".");
        System.out.println("These are the following items in the knapsack : ");
        for(int i = 0; i < items.length; i++) {
            System.out.println("Item number " + (i + 1) + " has a benefit of " + items[i].getBenefit() + " and a weight of " + items[i] + ".");
            System.out.printf("Resulting in a value(Benefit/Weight) of : %.3f", (double)items[i].getBenefit()/items[i].getWeight());
        }
        System.out.println("\nUsing the Greedy Algorithm resulted in the following items being added into the knapsack:");
        for(Item item : combo) {
            System.out.println(item);
        }
        System.out.println("For a total value of: " + totalBenefit);
    }
}
