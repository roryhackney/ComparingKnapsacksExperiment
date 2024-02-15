package KnapsackItems;

/**
 * Represents an Item that can be placed in a Knapsack
 * @author Rory Hackney
 */
public class Item {
    /** Benefit of the item which determines the value added if it's placed in a Knapsack */
    private int benefit;
    /** Weight of the item which limits whether it can be placed in a Knapsack */
    private int weight;

    /**
     * Creates an Item
     * @param benefit benefit of the Item; must be at least 1
     * @param weight weight of the Item; must be at least 1
     */
    public Item(int benefit, int weight) {
        if (benefit < 1) throw new IllegalArgumentException("benefit must be at least 1");
        if (weight < 1) throw new IllegalArgumentException("weight must be at least 1");
        this.benefit = benefit;
        this.weight = weight;
    }

    public int getBenefit() {return benefit;}
    public int getWeight() {return weight;}

    public String toString() {
        return String.format("(Benefit: %d, Weight: %d)", benefit, weight);
    }
}
