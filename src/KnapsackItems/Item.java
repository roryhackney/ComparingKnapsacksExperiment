package KnapsackItems;

/**
 * Represents an Item that can be placed in a Knapsack
 * @author Rory Hackney
 */
public class Item implements Comparable<Item> { // Added comparable needed for Greedy Algo, compared by value/weight
    /** Benefit of the item which determines the value added if it's placed in a Knapsack */
    private int benefit;
    /** Weight of the item which limits whether it can be placed in a Knapsack */
    private int weight;

    /**
     * Creates an Item
     * @param benefit benefit of the Item; must be at least 1
     * @param weight weight of the Item; must be at least 1
     */
    public Item(int benefit, int weight){
        if (benefit < 1) throw new IllegalArgumentException("benefit must be at least 1");
        if (weight < 1) throw new IllegalArgumentException("weight must be at least 1");
        this.benefit = benefit;
        this.weight = weight;
    }

    /**
     * Returns the benefit (profit) for this item
     * @return the benefit (profit) for this item
     */
    public int getBenefit() {return benefit;}

    /**
     * Returns the weight for this item
     * @return weight for this item
     */
    public int getWeight() {return weight;}

    @Override
    public String toString() {
        return String.format("(Benefit: %d, Weight: %d)", benefit, weight);
    }

    // Added - Comparison for benefit and weight ratio used in Greedy only
    @Override
    public int compareTo(Item other) {
        double ratioThis = (double) this.benefit / this.weight;
        double ratioOther = (double) other.benefit / other.weight;
        return Double.compare(ratioOther, ratioThis);
    }
}