import java.util.Random;

public class q13 {
    public static void main(String[] args) {

        int[] randomArray = generateRandomArray(10000); // Generate random array of size 10000

        int[] arrayStandard = randomArray.clone();
        int[] arrayEnhanced = randomArray.clone();
 

           // Sort the array using standard bubble sort and count comparisons
           int comparisonsStandard = bubbleSortStandard(arrayStandard);
           System.out.println("Standard Bubble Sort Comparisons: " + comparisonsStandard);
           
           // Sort the array using enhanced bubble sort and count comparisons
           int comparisonsEnhanced = bubbleSortEnhanced(arrayEnhanced);
           System.out.println("Enhanced Bubble Sort Comparisons: " + comparisonsEnhanced);
       }
   
       // Standard bubble sort with comparison count
       public static int bubbleSortStandard(int[] arr) {
           int n = arr.length;
           int comparisons = 0;
           for (int i = 0; i < n - 1; i++) {
               for (int j = 0; j < n - i - 1; j++) {
                   comparisons++; // Counting each comparison
                   if (arr[j] > arr[j + 1]) {
                       int temp = arr[j];
                       arr[j] = arr[j + 1];
                       arr[j + 1] = temp;
                   }
               }
           }
           return comparisons;
       }

           // Enhanced bubble sort with comparison count
    public static int bubbleSortEnhanced(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++; // Counting each comparison
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return comparisons;
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