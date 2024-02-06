//write code to implement the bubble sort sorting algorithm
// The bubble sort algorithm is a simple algorithm that sorts an array by repeatedly stepping through the list to be sorted, comparing each pair of adjacent items and swapping them if they are in the wrong order. The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted. The algorithm gets its name from the way smaller elements "bubble" to the top of the list. Because it only uses comparisons to operate on elements, it is a comparison sort. Although the algorithm is simple, it is too slow and impractical for most problems even when compared to insertion sort. It can be practical if the input is usually in sort order but may occasionally have some out-of-order elements nearly in position.
// The algorithm is as follows:
// 1. Start at the beginning of the array
// 2. Compare the first two elements of the array
// 3. If the first element is greater than the second element, swap them
// 4. Move to the next pair of elements
// 5. Repeat steps 2-4 until the end of the array
// 6. If any swaps were made, repeat steps 1-5 until no swaps are made
// 7. The array is now sorted
// The algorithm has a time complexity of O(n^2) and a space complexity of O(1).
// Example
// Input
// [5, 3, 8, 6, 2]
// Output
// [2, 3, 5, 6, 8]
// Input
// [3, 2, 1]
// Output
// [1, 2, 3]

import java.util.Arrays;

public class q2 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
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
    }
}

