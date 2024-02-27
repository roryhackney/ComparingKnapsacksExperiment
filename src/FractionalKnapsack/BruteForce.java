package FractionalKnapsack;

import KnapsackItems.Item;
import KnapsackItems.Knapsack;

/**
 * Brute force solution to the Fractional Knapsack problem: O(2^n)
 * @author Rory Hackney
 */
public class BruteForce {
    private double maxBenefit;

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
    //add any amount from 0% to 100% then go to next item
    //compare results for 0, 1, 2... 100 and return max

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
}