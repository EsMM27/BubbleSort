//Implement 2 tweaks to the code that can make this algorithm more efficient.

// 1. The first tweak is to add a flag to check if any swaps were made in the inner loop. If no swaps were made, then the array is already sorted and the algorithm can exit early. This reduces the time complexity in the best case scenario to O(n).
// 2. The second tweak is to reduce the number of iterations in the outer loop. After each pass through the
// array, the largest element is guaranteed to be in its correct position. Therefore, the algorithm can reduce the number of iterations in the outer loop by 1 after each pass. This reduces the time complexity in the best case scenario to O(n).
// The modified code is as follows:

import java.util.Arrays;

public class q3{

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2, 11};
        System.out.println("Before sorting: " + Arrays.toString(arr));
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

// The time complexity of the algorithm is O(n^2) in the worst case and O(n) in the best case. The space complexity is O(1).
// The space complexity of the algorithm is O(1) because it only uses a constant amount of extra space for the temp variable used in the swap operation. The space complexity is not dependent on the input size, so it is considered constant.
// The time complexity of the algorithm is O(n^2) in the worst case, where n is the number of elements in the array. This is because the algorithm has to make n-1 passes through the array, and in each pass, it has to compare and potentially swap each pair of adjacent elements. This results in a time complexity of O(n^2).
// In the best case, where the array is already sorted, the algorithm only needs to make one pass through the array to confirm that no swaps are needed. This results in a time complexity of O(n) in the best case. The best case occurs when the input is already in sorted order, and the algorithm can exit early without making any swaps.

