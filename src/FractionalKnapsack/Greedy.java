package FractionalKnapsack;

import KnapsackItems.Item;
import KnapsackItems.Knapsack;

import java.util.Arrays;

/**
 * Class implementation on Greedy algorithm for fractional Knapsack
 */
public class Greedy {

    private final double value;

    /**
     *
     * @param knapsack The knapsack object representing items
     */
    public Greedy(Knapsack knapsack) {
        Item[] items = knapsack.getItems();
        double capacity = knapsack.getCapacity();

        Arrays.sort(items);

        //Initialize total value to zero
        double totalValue = 0.0;

        //Iterate through  the sorted items
        for (Item item : items) {
            if (capacity <= 0) {
                break;
            }

            //Adding whole item to knapsack
            if (item.getWeight() <= capacity) {
                totalValue += item.getValue();
                capacity -= item.getWeight();
            } else {
                //Take a fraction of the item to fill remaining capacity
                double fraction = capacity / item.getWeight();
                totalValue += fraction * item.getValue();
                capacity = 0;
                break;
            }
        }
        this.value = totalValue;
    }




    public double getValue() {
        return value;
    }

    public static class Item implements Comparable<Item> {
        double value;
        double weight;

        public Item(double value, double weight) {
            this.value = value;
            this.weight = weight;
        }

        public int compareTo(Item other) {
            double ratioThis = this.value / this.weight;
            double ratioOther = other.value / other.weight;

            return Double.compare(ratioOther, ratioThis);
        }

        public double getValue() {
            return value;
        }

        public double getWeight() {
            return weight;
        }
    }

    public static class Knapsack {
        private int id;
        private Item[] items;
        private double capacity;

        public Knapsack(int id, Item[] items, double capacity) {
            this.id = id;
            this.items = items;
            this.capacity = capacity;
        }

        public int getId() {
            return id;
        }

        public Item[] getItems() {
            return items;
        }

        public double getCapacity() {
            return capacity;
        }
    }
}






