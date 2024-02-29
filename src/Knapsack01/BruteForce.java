package Knapsack01;
import KnapsackItems.Item;
import KnapsackItems.Knapsack;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implementation for BruteForce on a KnapSack 01 Problem
 *
 * @author KRB
 * @version 1.0
 */
public class BruteForce {
    /** Private List of Items variable to keep track of the best possible combination found **/
    private List<Item> bestCombo;
    /** Private integer variable to keep track of the best possible benefits found **/
    private int bestBenefit;
    /** Private integer variable to keep track of weight of the best possible combination found **/
    private int bestWeight;

    /**
     * Constructor for Brute Force Algorithm
     * @param knapsack Desired Knapsack to run algorithm through
     */
    public BruteForce(Knapsack knapsack){
        bestCombo = new ArrayList<>();
        Item[] items = knapsack.getItems();
        bestBenefit = 0;
        bestWeight = 0;
        int cap = knapsack.getCapacity();
        int numOfItems = items.length;

        int[] weights = new int[numOfItems];
        int[] benefits = new int[numOfItems];
        int[] bestChoice = new int[numOfItems];
        int[] itemInKnapsack = new int[numOfItems];

        for(int i = 0; i < numOfItems; i++) {
            weights[i] = items[i].getWeight();
            benefits[i] = items[i].getBenefit();
        }

        generateCombinations(items, cap, 0, bestChoice, weights, benefits, itemInKnapsack);

        for (int index = 0; index < bestChoice.length; index++) {
            if (bestChoice[index] == 1) {
                bestCombo.add(items[index]);
            }
        }
        System.out.println("\n(BRUTE FORCE) This is Knapsack number : " + knapsack.getId() + ".");
        System.out.println("The knapsack's capacity is : " + cap + ".");
        System.out.println("These are the following items available for the knapsack --- ");
        for(int i = 0; i < items.length; i++) {
            System.out.println("Item number " + (i + 1) + " has a benefit of " + items[i].getBenefit() + " and a weight of " + items[i].getWeight() + ".");
        }
        System.out.println("\nUsing the Brute Force Method resulted in the following items being added into the knapsack:");
        for(Item item : bestCombo) {
            System.out.println(item);
        }
        System.out.println("For a total benefit of: " + bestBenefit);
    }

    /**
     * Private recursive method to generate all possible combinations
     * @param items Items available for the knapsack
     * @param capacity Capacity of the knapsack
     * @param currentIndex Index of current item being examined
     * @param currentCombo Current combination of items being developed
     * @param weights Weights of all the items
     * @param benefits Benefits of all the items
     * @param itemInKnapsack Binary incrementation for items to go in the knapsack (0 for exclusion, 1 for inclusion)
     */
    private void generateCombinations(Item[] items, int capacity, int currentIndex, int[] currentCombo, int[] weights, int[] benefits, int[] itemInKnapsack) {
        if (currentIndex == items.length) {
            int tempWeight = 0;
            int tempBenefit = 0;
            for (int k = 0; k < items.length; k++) {
                if (itemInKnapsack[k] == 1) {
                    tempBenefit += benefits[k];
                    tempWeight += weights[k];
                }
            }

            if ((tempBenefit > bestBenefit) && (tempWeight <= capacity)) {
                bestBenefit = tempBenefit;
                bestWeight = tempWeight;
                System.arraycopy(itemInKnapsack, 0, currentCombo, 0, itemInKnapsack.length);
            }
        } else {
            itemInKnapsack[currentIndex] = 1;
            generateCombinations(items, capacity, currentIndex + 1, currentCombo, weights, benefits, itemInKnapsack);

            itemInKnapsack[currentIndex] = 0;
            generateCombinations(items, capacity, currentIndex + 1, currentCombo, weights, benefits, itemInKnapsack);
        }
    }
    /**
     * Method to return the best combination found
     * @return Combination that doesn't exceed the Knapsack's capacity
     */
    public List<Item> getBestCombo(){
        return bestCombo;
    }

    /**
     * Method to return the best benefit found
     * @return Total benefit from combination of Items that don't exceed the Knapsack's capacity
     */
    public int getBestBenefit(){
        return bestBenefit;
    }

    /**
     * Method to return the best total weight found
     * @return Total weight from combination of Items that don't exceed the Knapsack's capacity
     */
    public int getBestWeight(){
        return bestWeight;
    }
}
