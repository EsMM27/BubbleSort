import java.util.Arrays;
import java.util.Random;

public class q8 {
    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(100000);
         Arrays.sort(randomArray);
        //   //Reverse the sorted array

         int[] reversedArray = new int[randomArray.length];
          for (int i = 0; i < randomArray.length; i++) {
              reversedArray[i] = randomArray[randomArray.length - 1 - i];
          }

        long startTime = System.currentTimeMillis(); // Record the start time
        

         bubbleSort((randomArray)); // Sort the entire array


        for (int i = 0; i < 100000; i++) {
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

    // public static void bubbleSort(int[] arr) {
    //     int n = arr.length; // Get the length of the array
    //     // Loop through each element in the array
    //     for (int i = 0; i < n - 1; i++) {
    //         // Loop through the unsorted part of the array
    //         for (int j = 0; j < n - i - 1; j++) {
    //             // Compare adjacent elements
    //             if (arr[j] > arr[j + 1]) {
    //                 // Swap if the current element is greater than the next one
    //                 int temp = arr[j];
    //                 arr[j] = arr[j + 1];
    //                 arr[j + 1] = temp;
    //             }
    //         }
    //     }
    // }

    public static void bubbleSort(int[] arr) {
        int n = arr.length; // Get the length of the array
        boolean swapped; // Flag to track if any swaps occurred
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Initialize swapped to false for each pass
            // Loop through the unsorted part of the array
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap if the current element is greater than the next one
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Set swapped to true if a swap occurs
                }
            }
            // If no swaps occurred in this pass, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}
//non enhanced bubble sort
//on a random array of 100000 elements, the bubble sort algorithm took  15220 milliseconds to sort the array.
//on a sorted array of 100000 elements, the bubble sort algorithm took  6690 milliseconds to sort the array.
//on a reversed array of 100000 elements, the bubble sort algorithm took  6675 milliseconds to sort the array.

//enhanced bubble sort
//on a random array of 100000 elements, the bubble sort algorithm took  15492 milliseconds to sort the array.
//on a sorted array of 100000 elements, the bubble sort algorithm took  5702 milliseconds to sort the array.
//on a reversed array of 100000 elements, the bubble sort algorithm took  5719 milliseconds to sort the array.