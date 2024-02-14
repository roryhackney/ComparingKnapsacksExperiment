package KnapsackItems;

import java.io.File;
import java.util.Scanner;

public class FileReading {
    public Item[][] readAllFiles() {
        Item[][] knapsacks = new Item[][];
        knapsacks[0] = readFile("inputs.csv");
        for (int index = 1; index <= 6; index++) {
            knapsacks[index] = readFile("inputs" + index + ".csv");
        }
        return knapsacks;
    }
    /**
     * Reads the given file and returns a Knapsack that can be used for the Knapsack algorithms
     * @param filename the name of the file eg inputs4.csv. File must exist and be readable and be in KnapsackItems.
     * @return a Knapsack which contains the id, capacity, and an array of Items
     */
    public Item[] readFile(String filename) {
        File file = new File("src/KnapsackItems/" + filename);
        String[] values;
        String[] weights;
        try {
            Scanner scanner = new Scanner(file);
            int knapsackNum = scanner.nextInt();
            int knapsackCap = scanner.nextInt();
            scanner.nextLine();
            values = scanner.nextLine().strip().split(",");
            weights = scanner.nextLine().strip().split(",");
            scanner.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("File could not be read");
        }
        Item[] items = new Item[];
        for (int index = 0; index < values.length; index++) {
            items[index] = new Item(Integer.parseInt(values[index]), Integer.parseInt(weights[index]));
        }
        return items;
    }
}
