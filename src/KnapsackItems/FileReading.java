package KnapsackItems;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class FileReading {
    private FileReading() {}

//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(readAllFiles()));
//    }

    public static Knapsack[] readAllFiles() {
        Knapsack[] knapsacks = new Knapsack[6];
        knapsacks[0] = readFile("inputs.csv");
        for (int fileNum = 2; fileNum <= 6; fileNum++) {
            knapsacks[fileNum - 1] = readFile("inputs" + fileNum + ".csv");
        }
        return knapsacks;
    }
    /**
     * Reads the given file and returns a Knapsack that can be used for the Knapsack algorithms
     * @param filename the name of the file, e.g. inputs4.csv. File must exist and be readable and be in KnapsackItems/
     * @return a Knapsack which contains the id, capacity, and an array of Items
     */
    public static Knapsack readFile(String filename) {
        File file = new File("src/KnapsackItems/" + filename);
        String[] values;
        String[] weights;
        int knapsackNum;
        int knapsackCap;
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");
            knapsackNum = scanner.nextInt();
            knapsackCap = scanner.nextInt();
            scanner.nextLine();
            values = scanner.nextLine().strip().split(",");
            weights = scanner.nextLine().strip().split(",");
            scanner.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("File could not be read: " + filename + e);
        }
        Item[] items = new Item[values.length];
        for (int index = 0; index < values.length; index++) {
            items[index] = new Item(Integer.parseInt(values[index]), Integer.parseInt(weights[index]));
        }
        return new Knapsack(knapsackNum, knapsackCap, items);
    }
}
