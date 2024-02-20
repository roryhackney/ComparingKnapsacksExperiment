package FractionalKnapsack;

import KnapsackItems.Item;
import KnapsackItems.Knapsack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Brute force solution to the Fractional Knapsack problem: O(2^n)
 * @author Rory Hackney
 */
public class BruteForce {
    public static void main(String[] args) {
//        System.out.println(
        displayWeightAndBenefit(
                new Knapsack(1, 5, new Item[]{new Item(3, 3), new Item(2, 2), new Item(1, 1)}),
                2, 0, 0, new ArrayList<>());
        //);
    }

    //need: items (weight, benefit, item number)
    //I think recursively split between (include this) and (don't include this)
    //then return the max of the two such that the weight <= max
    //if the remaining weight is a fraction, just add that much of current item
    //do we return the final value? the sequence of items/amount?
    public static void test(int n, String test) {
        if (n < 1) {
            System.out.println("[" + test + "]");
        } else {
            test(n - 1, 0 + test);
            test(n - 1, 1 + test);
        }
    }

    public static void testItems(Item[] items, int currentIndex, String test) {
        if (currentIndex < 0) {
            System.out.println("[" + test + "]");
        } else {
            testItems(items, currentIndex - 1, test);
            testItems(items, currentIndex - 1, items[currentIndex] + test);
        }
    }

    public static int testTotalBenefit(Item[] items, int currentIndex, int sum) {
        if (currentIndex < 0) {
            return sum;
        }
        return Math.max(testTotalBenefit(items, currentIndex - 1, sum),
                testTotalBenefit(items, currentIndex - 1, sum + items[currentIndex].getBenefit()));
    }

    public static int testTotalBenefit(Knapsack sack, int currentIndex, int sum) {
        if (currentIndex < 0) return sum;
        return Math.max(testTotalBenefit(sack, currentIndex - 1, sum),
                testTotalBenefit(sack, currentIndex - 1, sum + sack.getItems()[currentIndex].getBenefit()));
    }

    //problem: we are passing the same arraylist around, so it is adding the same item multiple times
    public static void displayWeightAndBenefit(Knapsack sack, int currentIndex, int sum, int weight, ArrayList<Item> items) {
        if (currentIndex < 0) {
            System.out.println("Items: " + items);
            System.out.println("Profit: " + sum);
            System.out.println("Weight: " + weight);
        } else {
            displayWeightAndBenefit(sack, currentIndex - 1, sum, weight, (ArrayList<Item>) items.clone()); //don't add
            if (weight + sack.getItems()[currentIndex].getWeight() <= sack.getCapacity()) {
                items.add(sack.getItems()[currentIndex]);
                displayWeightAndBenefit(sack, currentIndex - 1,
                        sum + sack.getItems()[currentIndex].getBenefit(),
                        weight + sack.getItems()[currentIndex].getWeight(), (ArrayList<Item>) items.clone()); //do add
            } else {
                int diff = sack.getCapacity() - weight; //have space for 2 weight
                if (diff > 0) { // if there is room for stuff
                    double ratio = diff / (double) sack.getItems()[currentIndex].getWeight();
                    double profit = ratio * sack.getItems()[currentIndex].getBenefit(); //
//                    System.out.println("profit" + profit + ", diff" + diff + "ratio" + ratio);
                    items.add(sack.getItems()[currentIndex]);
                    displayWeightAndBenefit(sack, currentIndex - 1,
                            (int) (sum + profit), sack.getCapacity(), (ArrayList<Item>) items.clone());
                }
            }
        }
    }



    public int solveTheProblem(Knapsack sack) {
        System.out.println("For knapsack #" + sack.getId() + " with a capacity of " + sack.getCapacity());
        System.out.println("Potential items: " + Arrays.toString(sack.getItems()));

        System.out.println("The max possible profit is ");
        System.out.println("Added items: " + "including " + "units of item " + "with a value of ");

        int maxProfit = solveTheProblem(sack, items.length - 1, 0, 0, "");
    }

    private int solveTheProblem(Knapsack sack, int currentItem, int profit, int weight, String display) {
        if (currentItem <= 0 || sack.getCapacity() <= weight) {

        } else {
            return Math.max(solveTheProblem(sack, currentItem - 1, profit, weight, display),
                    solveTheProblem(sack, currentItem - 1, profit + items[currentItem].getBenefit()))
        }
    }

}
