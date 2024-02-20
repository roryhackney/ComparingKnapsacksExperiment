package FractionalKnapsack;

import KnapsackItems.Item;
import KnapsackItems.Knapsack;
import java.util.Arrays;

/**
 * Class implementation on Greedy algorithm for fractional Knapsack
 */

// TODO: Remove knapsack class and item class, getting an error when implementing charts.
//  Looks like algo is created in Constructor, no separate function was created.
public class Greedy {

    private final double value;
    /**
     * @param knapsack The knapsack object representing items
     */
    public Greedy(Knapsack knapsack) {
        Item[] items = knapsack.getItems();
        double capacity = knapsack.getCapacity();

        Arrays.sort(items);

        //Initialize total value to zero
        double totalValue = 0.0;

        //Iterate through  the sorted items
        for (Item item : items) {
            if (capacity <= 0) {
                break;
            }

            //Adding whole item to knapsack
            if (item.getWeight() <= capacity) {
                totalValue += item.getBenefit();
                capacity -= item.getWeight();
            } else {
                //Take a fraction of the item to fill remaining capacity
                double fraction = capacity / item.getWeight();
                totalValue += fraction * item.getBenefit();
                capacity = 0;
                break;
            }
        }
        this.value = totalValue;
    }

    public double getValue() {
        return value;
    }

}