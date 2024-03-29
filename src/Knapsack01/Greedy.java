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
    /** Private List of Items variable for the best possible combinations **/
    private List<Item> bestCombo;
    /** Private integer variable for the best possible benefits **/
    private int bestBenefit;
    /**
     * Constructor for Greedy Algorithm
     * @param knapsack Desired Knapsack to run algorithm through
     */
    public Greedy(Knapsack knapsack) {
        bestCombo = new ArrayList<>();
        bestBenefit = 0;
        Item[] items = knapsack.getItems();
        int cap = knapsack.getCapacity();
        int totalLoad = 0;

        Arrays.sort(items);

        for (Item item : items) {
            if (totalLoad + item.getWeight() <= cap) {
                totalLoad += item.getWeight();
                bestBenefit += item.getBenefit();
                bestCombo.add(item);
            }
        }
        System.out.println("\n(GREEDY METHOD) This is Knapsack number : " + knapsack.getId() + ".");
        System.out.println("The knapsack's capacity is : " + cap + ".");
        System.out.println("These are the following items available for the knapsack --- ");
        for(int i = 0; i < items.length; i++) {
            System.out.printf("Item number " + (i + 1) + " has a benefit of " + items[i].getBenefit() + " and a weight of " + items[i].getWeight() +
                    ". Resulting in a value (Benefit/Weight) = %.3f\n", (double)items[i].getBenefit()/items[i].getWeight());
        }
        System.out.println("\nUsing the Greedy Algorithm resulted in the following items being added into the knapsack:");
        for(Item item : bestCombo) {
            System.out.println(item);
        }
        System.out.println("For a total benefit of: " + bestBenefit);
    }

    /**
     * Method to return the best combination found
     * @return Combination that doesn't exceed the Knapsack's capacity
     */
    public List<Item> getBestCombo() {
        return bestCombo;
    }

    /**
     * Method to return the best benefit found
     * @return Total benefit from combination of Items that don't exceed the Knapsack's capacity
     */
    public int getBestBenefit() {
        return bestBenefit;
    }
}
