package FractionalKnapsack;

import KnapsackItems.Item;
import KnapsackItems.Knapsack;

import java.util.Arrays;

/**
 * class implementation of greedy fractional knapsack algorithm
 */
public class Greedy {

    /**
     * @param knapsack The knapsack object representing items
     */
    public static double solveFractionalKnapsack(Knapsack knapsack) {
        Item[] items = knapsack.getItems();
        int capacity = knapsack.getCapacity();

        //Sort items based on benefit to weight ratio in descending order
        Arrays.sort(items, (item1, item2) -> {
            double ratio1 = item1.getBenefit() / (double) item1.getWeight();
            double ratio2 = item2.getBenefit() / (double) item2.getWeight();
            return Double.compare(ratio2, ratio1);
        });

        double totalBenefit = 0.0;

        for (Item item : items) {
            if (capacity <= 0) {
                break;
            }

            if (item.getWeight() <= capacity) {
                totalBenefit += item.getBenefit();
                capacity -= item.getWeight();
            } else {
                double fraction = (double) capacity / item.getWeight();
                totalBenefit += fraction * item.getBenefit();
                capacity = 0;
                break;
            }
        }

        return totalBenefit;
    }
}



