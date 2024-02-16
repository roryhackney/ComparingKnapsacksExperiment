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

    public BruteForce(Knapsack knapsack){
        Item[] items = knapsack.getItems();
        int cap = knapsack.getCapacity();

        int currentLoad = 0;
        int currentBenefit = 0;
        List<Item> combo = new ArrayList<>();

        for(int i = 0; i < items.length; i++) {
            int currentItemWeight = items[i].getWeight();
            if (currentLoad < cap && (currentLoad + currentItemWeight) <= cap) {
                currentLoad += currentItemWeight;
                combo.add(items[i]);
                currentBenefit += items[i].getBenefit();
            } else {
                break;
            }
        }
    }
}
