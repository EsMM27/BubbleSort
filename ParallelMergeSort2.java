import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort2 {
    private static final int THRESHOLD = 1000; // Adjust the threshold value

    public static void main(String[] args) {
        int[] array = generateRandomArray(1000000);

        long startTime = System.currentTimeMillis(); // Record the start time

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelMergeSortTask(array, 0, array.length));

        

        // Print the sorted array
        for (int num : array) {
            System.out.println(num);
        }

        long endTime = System.currentTimeMillis(); // Record the end time
        long totalTime = endTime - startTime; // Calculate the total time taken
        System.out.println("Time taken to sort array: " + totalTime + " milliseconds");
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    static class ParallelMergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int start;
        private final int end;

        public ParallelMergeSortTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                Arrays.sort(array, start, end); // Use sequential sorting for small arrays
            } else {
                int mid = start + (end - start) / 2;
                ParallelMergeSortTask leftTask = new ParallelMergeSortTask(array, start, mid);
                ParallelMergeSortTask rightTask = new ParallelMergeSortTask(array, mid, end);
                leftTask.fork();
                rightTask.compute();
                leftTask.join();
                merge(array, start, mid, end);
            }
        }

        private void merge(int[] array, int start, int mid, int end) {
            // Merge operation to merge sorted subarrays (not shown here for brevity)
        }
    }
}