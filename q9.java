import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class q9 {
    public static void main(String[] args) {
        ArrayList<Integer> randomList = generateRandomArrayList(100000);
        
        // Sort the random list using Collections.sort method
        //Collections.sort(randomList);
        
        // Reverse the sorted list
        //Collections.reverse(randomList);
        
        long startTime = System.currentTimeMillis(); // Record the start time
        
        bubbleSort(randomList); // Sort the entire list
        
        // Print the first 100,000 elements of the list
        for (int i = 0; i < 100000; i++) {
            System.out.println(randomList.get(i));
        }
        
        long endTime = System.currentTimeMillis(); // Record the end time
        long totalTime = endTime - startTime; // Calculate the total time taken
        System.out.println("Time taken to generate random array: " + totalTime + " milliseconds");
    }

    public static ArrayList<Integer> generateRandomArrayList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        // Fill the list with random integers
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt());
        }
        return list;
    }

    public static void bubbleSort(ArrayList<Integer> list) {
        int n = list.size(); // Get the size of the list
        boolean swapped; // Flag to track if any swaps occurred
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Initialize swapped to false for each pass
            // Loop through the unsorted part of the list
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (list.get(j) > list.get(j + 1)) {
                    // Swap if the current element is greater than the next one
                    Collections.swap(list, j, j + 1);
                    swapped = true; // Set swapped to true if a swap occurs
                }
            }
            // If no swaps occurred in this pass, the list is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}
//random array of size 100000 has the speed of 42574 milliseconds
