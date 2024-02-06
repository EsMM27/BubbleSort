import java.util.Arrays;
import java.util.Random;

public class CustomSorting {
    public static void main(String[] args) {
        // Create inputArray with random numbers
        int[] inputArray = generateRandomArray(100000);

        long startTime = System.currentTimeMillis(); // Record the start time
        // Sort the inputArray in-place
        insertionSort(inputArray);

        // Print the sorted inputArray
        for (int num : inputArray) {
            System.out.println(num);
        }

        long endTime = System.currentTimeMillis(); // Record the end time
        long totalTime = endTime - startTime; // Calculate the total time taken
        System.out.println("Time taken to generate random array: " + totalTime + " milliseconds");
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            // Find the correct position for the current element
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Insert the current element at the correct position
            arr[j + 1] = current;
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size]; // Create an array of given size
        Random rand = new Random(); // Create a random number generator
        // Fill the array with random integers
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(); // Generate a random integer
        }
        return arr; // Return the generated array
    }
}