import java.util.Random;

public class q14 {
    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(10000); // Generate random array of size 10000

        int[] arrayStandard = randomArray.clone();
        int[] arrayEnhanced = randomArray.clone();

        // Sort the array using standard bubble sort and count swaps
        int swapsStandard = bubbleSortStandard(arrayStandard);
        System.out.println("Standard Bubble Sort Swaps: " + swapsStandard);

        // Sort the array using enhanced bubble sort and count swaps
        int swapsEnhanced = bubbleSortEnhanced(arrayEnhanced);
        System.out.println("Enhanced Bubble Sort Swaps: " + swapsEnhanced);
    }

    // Standard bubble sort with swap count
    public static int bubbleSortStandard(int[] arr) {
        int n = arr.length;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements and count swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
        return swaps;
    }

    // Enhanced bubble sort with swap count
    public static int bubbleSortEnhanced(int[] arr) {
        int n = arr.length;
        int swaps = 0;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements and count swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return swaps;
    }

    // Generate random array
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }
}