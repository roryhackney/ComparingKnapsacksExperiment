package FractionalKnapsack;

import KnapsackItems.Item;
import KnapsackItems.Knapsack;

/**
 * Brute force solution to the Fractional Knapsack problem: O(2^n)
 * @author Rory Hackney
 */
public class BruteForce {
    private double maxBenefit;
//    private String finalItems;

    /**
     * Solves the fractional knapsack problem for the given knapsack
     * @param knapsack the knapsack to solve the problem for, with capacity and array of usable items
     */
    public BruteForce(Knapsack knapsack) {
        maxBenefit = solveTheProblem(knapsack);
    }

    /**
     * Returns the maximum profit for the knapsack most recently solved
     * @return maximum profit for the most recent knapsack solution
     */
    public double getMaxBenefit() {return maxBenefit;}

    /**
     * Solves the fractional knapsack problem for the given knapsack
     * @param sack the knapsack to solve the problem for, with capacity and array of usable items
     * @return the maximum profit for the given knapsack
     */
    public double solveTheProblem(Knapsack sack) {
        return solveTheProblem(sack, 0, 0, sack.getItems().length - 1);
    }
    //ok so break items into 100 pieces (1/100 * value, 1/100 * weight)
    //array of length n, to track how many added?
    //add any amount from 0 to 100 then go to next item

    //math.max(0, 1, 2, 3, 4...100)

    /**
     * Recursively solves the knapsack problem and returns the maximum profit
     * @param sack the knapsack which has usable items and max capacity
     * @param weight current weight for this attempt
     * @param profit current profit for this attempt
     * @param index index of the item currently being added
     * @return maximum profit of the knapsack
     */
    public double solveTheProblem(Knapsack sack, double weight, double profit, int index) {
        if (index < 0 || Double.compare(weight, sack.getCapacity()) >= 0) {
            return profit;
        } else {
            Item itemToAdd = sack.getItems()[index];
            double partialAdd = solveTheProblem(sack, weight, profit, index - 1);
            for (int amountToAdd = 1; amountToAdd <= 100; amountToAdd++) {
                double fraction = amountToAdd / 100.0;
                double weightToAdd = itemToAdd.getWeight() * fraction;
                if (Double.compare(weightToAdd + weight, sack.getCapacity()) <= 0) {
                    double profitToAdd = itemToAdd.getBenefit() * fraction;
                    partialAdd = Math.max(partialAdd,
                            solveTheProblem(sack, weight + weightToAdd, profit + profitToAdd, index - 1));
                }
            }
            return partialAdd;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    //ignore below, had to comment out previous attempts and partial solutions//

    ////////////////////////////////////////////////////////////////////////////




//    /**
//     * Returns a String listing the items used for the knapsack most recently solved
//     * @return a String of the items used for the most recent knapsack solution
//     */
//    public String getFinalItems() {return finalItems;}

//    /**
//     * Recursive brute force solution for the fractional knapsack problem
//     * @param sack knapsack to solve the problem for, holding capacity and usable items
//     * @return the total max profit for the knapsack problem
//     */
//    public double solveTheProblem(Knapsack sack) {
//        maxBenefit = solveTheProblem(sack, sack.getItems().length - 1, 0.0, 0, "");
//        return maxBenefit;
//    }

//    /**
//     * Private recursive method for the fractional knapsack problem
//     * @param sack knapsack to solve the problem for, holding capacity and usable items
//     * @param currentIndex index of the current item to be considered
//     * @param profit current total profit of the items chosen so far
//     * @param weight current total weight of the items chosen so far
//     * @param items String listing the items chosen so far
//     * @return maximum profit when optimal items are chosen from usable items
//     */
//    private double solveTheProblem(Knapsack sack, int currentIndex, double profit, int weight, String items) {
//        if (currentIndex < 0 || weight >= sack.getCapacity()) {
//            if (Double.compare(profit, this.maxBenefit) > 0) this.finalItems = items;
////            System.out.println(items);
//            return profit;
//        } else {
//            Item item = sack.getItems()[currentIndex];
//            if (weight + item.getWeight() > sack.getCapacity()) {
//                double ratio = (double) (sack.getCapacity() - weight) / item.getWeight();
//                double benefitToAdd = ratio * item.getBenefit();
//                return Math.max(solveTheProblem(sack, currentIndex - 1, profit, weight, items),
//
//                        solveTheProblem(sack, currentIndex - 1, profit + benefitToAdd, sack.getCapacity(),
//                                "Full amounts of items" + items + String.format("\nPartial benefit %.2f, weight %d of item %s",
//                                        benefitToAdd, (sack.getCapacity() - weight), item)));
//            } else {
//                return Math.max(solveTheProblem(sack, currentIndex - 1, profit, weight, items),
//                        solveTheProblem(sack, currentIndex - 1, profit + item.getBenefit(),
//                                weight + item.getWeight(), item + items));
//            }
//        }
//    }





    //in between methods written while puzzling out solution

    //    public static void main(String[] args) {
    ////        displayWeightAndBenefit(
    ////                new Knapsack(1, 5, new Item[]{new Item(3, 3), new Item(2, 2), new Item(1, 1)}),
    ////                2, 0, 0, new ArrayList<>());
    //
    //        Knapsack bag = new Knapsack(1, 5, new Item[]{new Item(3, 3), new Item(2, 2), new Item(1, 1)});
    //        int res = solveTheProblem(bag);
    //        System.out.println(res);
    //    }

    //need: items (weight, benefit, item number)
    //I think recursively split between (include this) and (don't include this)
    //then return the max of the two such that the weight <= max
    //if the remaining weight is a fraction, just add that much of current item
    //do we return the final value? the sequence of items/amount?
    //    public static void test(int n, String test) {
    //        if (n < 1) {
    //            System.out.println("[" + test + "]");
    //        } else {
    //            test(n - 1, 0 + test);
    //            test(n - 1, 1 + test);
    //        }
    //    }
    //
    //    public static void testItems(Item[] items, int currentIndex, String test) {
    //        if (currentIndex < 0) {
    //            System.out.println("[" + test + "]");
    //        } else {
    //            testItems(items, currentIndex - 1, test);
    //            testItems(items, currentIndex - 1, items[currentIndex] + test);
    //        }
    //    }
    //
    //    public static double testTotalBenefit(Item[] items, int currentIndex, double sum) {
    //        if (currentIndex < 0) {
    //            return sum;
    //        }
    //        return Math.max(testTotalBenefit(items, currentIndex - 1, sum),
    //                testTotalBenefit(items, currentIndex - 1, sum + items[currentIndex].getBenefit()));
    //    }
    //
    //    public static double testTotalBenefit(Knapsack sack, int currentIndex, double sum) {
    //        if (currentIndex < 0) return sum;
    //        return Math.max(testTotalBenefit(sack, currentIndex - 1, sum),
    //                testTotalBenefit(sack, currentIndex - 1, sum + sack.getItems()[currentIndex].getBenefit()));
    //    }
    //
    //    //problem: we are passing the same arraylist around, so it is adding the same item multiple times
    //    public static void displayWeightAndBenefit(Knapsack sack, int currentIndex, double sum, double weight, ArrayList<Item> items) {
    //        if (currentIndex < 0) {
    //            System.out.println("Items: " + items);
    //            System.out.println("Profit: " + sum);
    //            System.out.println("Weight: " + weight);
    //        } else {
    //            displayWeightAndBenefit(sack, currentIndex - 1, sum, weight, (ArrayList<Item>) items.clone()); //don't add
    //            if (weight + sack.getItems()[currentIndex].getWeight() <= sack.getCapacity()) {
    //                items.add(sack.getItems()[currentIndex]);
    //                displayWeightAndBenefit(sack, currentIndex - 1,
    //                        sum + sack.getItems()[currentIndex].getBenefit(),
    //                        weight + sack.getItems()[currentIndex].getWeight(), (ArrayList<Item>) items.clone()); //do add
    //            } else {
    //                double diff = sack.getCapacity() - weight; //have space for 2 weight
    //                if (diff > 0) { // if there is room for stuff
    //                    double ratio = diff / (double) sack.getItems()[currentIndex].getWeight();
    //                    double profit = ratio * sack.getItems()[currentIndex].getBenefit(); //
    ////                    System.out.println("profit" + profit + ", diff" + diff + "ratio" + ratio);
    //                    items.add(sack.getItems()[currentIndex]);
    //                    displayWeightAndBenefit(sack, currentIndex - 1,
    //                            (int) (sum + profit), sack.getCapacity(), (ArrayList<Item>) items.clone());
    //                }
    //            }
    //        }
    //    }
}
