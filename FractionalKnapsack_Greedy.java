import java.util.*;

class Item {
    int value, weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Solve {

    static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // Create a list of items using the value and weight lists
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < val.size(); i++) {
            items.add(new Item(val.get(i), wt.get(i)));
        }

        // Sort items by value-to-weight ratio in descending order
        items.sort((a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        int curWeight = 0; 
        double finalValue = 0.0;

        // Process each item
        for (Item item : items) {
            if (curWeight + item.weight <= capacity) {
                curWeight += item.weight;
                finalValue += item.value;
            } else {
                int remain = capacity - curWeight;
                finalValue += ((double) item.value / item.weight) * remain;
                break;
            }
        }

        return finalValue;
    }

    public static void main(String[] args) {
        List<Integer> val = Arrays.asList(100, 60, 120);
        List<Integer> wt = Arrays.asList(20, 10, 30);
        int capacity = 50;

        double maxValue = fractionalKnapsack(val, wt, capacity);
        System.out.println("The maximum value is " + maxValue);
    }
}
