package KnapsackItems;

/**
 * Represents an Item that can be placed in a Knapsack
 * @author Rory Hackney
 */
public class Item {
    /** Weight of the item which limits whether it can be placed in a Knapsack */
    private int weight;
    /** Benefit of the item which determines the value added if it's placed in a Knapsack */
    private int benefit;

    /**
     * Creates an Item
     * @param weight weight of the Item; must be at least 1
     * @param benefit benefit of the Item; must be at least 1
     */
    public Item(int weight, int benefit) {
        if (weight < 1) throw new IllegalArgumentException("weight must be at least 1");
        if (benefit < 1) throw new IllegalArgumentException("benefit must be at least 1");
        this.weight = weight;
        this.benefit = benefit;
    }

    public int getWeight() {return weight;}
    public int getBenefit() {return benefit;}
}
