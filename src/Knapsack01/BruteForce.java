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

        for (int i = 1; i <= Math.pow(2, numOfItems); i++) {
            int j = numOfItems - 1;
            int tempWeight = 0;
            int tempBenefit = 0;

            while(itemInKnapsack[j] != 0 && j > 0) {
                itemInKnapsack[j] = 0;
                j--;
            }
            itemInKnapsack[j] = 1;
            for (int k = 0; k < numOfItems; k++) {
                if (itemInKnapsack[k] == 1) {
                   tempBenefit += benefits[k];
                   tempWeight += weights[k];
                }
            }
            if ((tempBenefit > bestBenefit) && (tempWeight <= cap)){
                bestBenefit = tempBenefit;
                bestWeight = tempWeight;
            }
            bestChoice = itemInKnapsack;
        }

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
        System.out.println("For a total value of: " + bestBenefit);
//        generateCombos(items, cap, 0, new ArrayList<>());
    }
//
//    /**
//     * Method to generate all different possible combinations with all the Items available
//     * @param items Array of Item objects
//     * @param cap Capacity of the knapsack
//     * @param currentIndex Location of current Item in knapsack being inspected
//     * @param currentCombo A combination of items being put together
//     */
//    private void generateCombos(Item[] items, int cap, int currentIndex, List<Item> currentCombo) {
//        if (currentIndex == items.length) {
//            int currentWeight = calculateTotalWeight(currentCombo);
//            int currentBenefit = calculateTotalBenefit(currentCombo);
//
//            if (currentWeight <= cap && currentBenefit > bestBenefit) {
//                bestBenefit = currentBenefit;
//                bestCombo = new ArrayList<>(currentCombo);
//            }
//            return;
//        }
//        currentCombo.add(items[currentIndex]);
//        generateCombos(items, cap, currentIndex + 1, currentCombo);
//        currentCombo.remove(currentCombo.size() - 1);
//        generateCombos(items, cap, currentIndex + 1, currentCombo);
//    }
//
//    /**
//     * Method to calculate the total weight of a List of Items
//     * @param combo Combination of items to inspect
//     * @return Total weight of items on the List
//     */
//    private int calculateTotalWeight(List<Item> combo) {
//        int totalWeight = 0;
//        for(Item item : combo) {
//            totalWeight += item.getWeight();
//        }
//        return totalWeight;
//    }
//
//    /**
//     * Method to calculate the total benefit of a List of Items
//     * @param combo Combination of items to inspect
//     * @return Total benefit from items on the List
//     */
//    private int calculateTotalBenefit(List<Item> combo) {
//        int totalBenefit = 0;
//        for (Item item : combo) {
//            totalBenefit += item.getBenefit();
//        }
//        return totalBenefit;
//    }

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
