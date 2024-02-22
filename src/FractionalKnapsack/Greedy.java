package FractionalKnapsack;

import KnapsackItems.Item;
import KnapsackItems.Knapsack;
import java.util.Arrays;

/**
* Class implementation of greedy fractional knapsack algorithm
 * @author rosie
*/
public class Greedy {
	private final double value;

	/**
	 *
	 * @param knapsack the knapsack object representing items
	 */
	public Greedy(Knapsack knapsack) {
	  this.value = solveFractionalKnapsack(knapsack);
  }
  /**
	* @param knapsack The knapsack object representing items
   * @return the total value obtained by adding items to the knapsack
	*/
	public static double solveFractionalKnapsack(Knapsack knapsack) {
		Item[] items = knapsack.getItems();
		int capacity = knapsack.getCapacity();

		//sort the items in descending order based on their value-to-weight ratio
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
		return totalBenefit;
	}

	public double getValue() {
		return value;
	}
}