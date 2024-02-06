import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ParallelMergeSort {
    public static void main(String[] args) {
        // Generate random array
        int[] array = generateRandomArray(100000);

        long startTime = System.currentTimeMillis(); // Record the start time

        // Sort the array using parallel merge sort
        int[] sortedArray = parallelMergeSort(array);


        // Print the sorted array
        for (int num : sortedArray) {
            System.out.println(num);
        }
        long endTime = System.currentTimeMillis(); // Record the end time
        long totalTime = endTime - startTime; // Calculate the total time taken
        System.out.println("Time taken to sort array: " + totalTime + " milliseconds");
    }

    public static int[] parallelMergeSort(int[] array) {
        // Create a thread pool with available processors
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(processors);

        // Create a list to hold the sorted subarrays
        List<Future<int[]>> sortedSubarrays = new ArrayList<>();

        // Split the array into chunks and sort each chunk in parallel
        int chunkSize = array.length / processors;
        for (int i = 0; i < processors; i++) {
            int start = i * chunkSize;
            int end = (i == processors - 1) ? array.length : (i + 1) * chunkSize;
            int[] subarray = new int[end - start];
            System.arraycopy(array, start, subarray, 0, end - start);
            Callable<int[]> task = new SortTask(subarray);
            Future<int[]> future = executorService.submit(task);
            sortedSubarrays.add(future);
        }

        // Wait for all sorting tasks to complete and merge the sorted subarrays
        int[] result = new int[array.length];
        int index = 0;
        for (Future<int[]> future : sortedSubarrays) {
            try {
                int[] sortedSubarray = future.get();
                System.arraycopy(sortedSubarray, 0, result, index, sortedSubarray.length);
                index += sortedSubarray.length;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor service
        executorService.shutdown();

        // Merge all sorted subarrays to get the final sorted array
        return mergeArrays(result, processors);
    }

    public static int[] mergeArrays(int[] array, int numArrays) {
        // Implement merge operation to merge sorted subarrays
        // (not shown here for brevity)
        return array;
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }
}

class SortTask implements Callable<int[]> {
    private final int[] array;

    public SortTask(int[] array) {
        this.array = array;
    }

    @Override
    public int[] call() {
        // Sort the subarray using any sorting algorithm (e.g., quicksort)
        // For simplicity, we use Arrays.sort here
        Arrays.sort(array);
        return array;
    }
}