package FractionalKnapsack;

import KnapsackItems.Item;
import KnapsackItems.Knapsack;
import java.util.Arrays;

/**
* Class implementation of greedy fractional knapsack algorithm
*/

// TODO: Remove knapsack class and item class, getting an error when implementing charts.
// Looks like algo is created in Constructor, no seperate function was created.
public class Greedy {
  
  private final double value;
	
  /**
	* @param knapsack The knapsack object representing items
	*/
	public static double solveFractionalKnapsack(Knapsack knapsack) {
		Item[] items = knapsack.getItems();
		int capacity = knapsack.getCapacity();

		Arrays.sort(items);

		//Initialize total value to zero
		double totalBenefit = 0.0;

		//Iterate through the sorted items
		for (Item item : items) {
			if (capacity <= 0) {
				break;
			}

			//Adding whole item to knapsack
			if (item.getWeight() <= capacity) {
				totalBenefit += item.getBenefit();
				capacity -= item.getWeight();
			} else {
				//Take a fraction of the item to fill remaining capacity
				double fraction = (double) capacity / item.getWeight();
				totalBenefit += fraction * item.getBenefit();
				capacity = 0;
				break;
			}
		}
		this.value = totalBenefit;
		return totalBenefit;
	}

	public double getValue() {
		return value;
	}
}