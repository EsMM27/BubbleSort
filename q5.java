import java.util.Arrays;
import java.util.Random;

public class q5 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Record the start time
        int[] randomArray = generateRandomArray(10000); // Generate random array of size 10000
        Arrays.sort(randomArray);
 

        for (int i = 0; i < 10000; i++) {
            System.out.println(randomArray[i]);
        }
        long endTime = System.currentTimeMillis(); // Record the end time
        long totalTime = endTime - startTime; // Calculate the total time taken
        System.out.println("Time taken to generate random array: " + totalTime + " milliseconds");

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

