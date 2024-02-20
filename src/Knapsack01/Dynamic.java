package Knapsack01;

import KnapsackItems.Item;

import java.util.Arrays;

public class Dynamic {
    /**
     * Calculates the maximum value that can be obtained by
     * selecting items for the knapsack without exceeding the
     * sack capacity.
     *
     * @param sackCapacity  knapsack capacity
     * @param items         array of items showing the available items
     * @return              the maximum value that can be obtained
     */
    public long GetMaxValue(int sackCapacity, Item[] items) {   // int[] weights, int[] values){
        int n = items.length;

        // store the maximum value at each capacity with different items
        int[][] matrix = new int[n + 1][sackCapacity + 1];

        // initialize with zeros
        for (int i = 0; i < sackCapacity + 1; i++) {
            matrix [0][i] = 0;
        }
        for (int j = 0; j < n + 1; j++) {
            matrix [j][0] = 0;
        }
        // Fill with the maximum values
        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= sackCapacity; capacity++) {
                int maxValWOCurr = matrix[item - 1][capacity];
                int maxValWCurr = 0;

                int curWeight = items[item - 1].getWeight();
                if (capacity >= curWeight) {
                    maxValWCurr = items[item - 1].getBenefit();

                    // Remaining capacity after including the current item
                    int remainingCapacity = capacity - curWeight;
                    maxValWCurr += matrix[item - 1][remainingCapacity];
                }
                // Store the maximum Value
                matrix[item][capacity] = Math.max(maxValWOCurr, maxValWCurr);
            }
        }
        // Return the maximum value for the given sack capacity
        return matrix[n][sackCapacity];
    }
}
