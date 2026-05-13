class Solution {
    // Correctly swaps two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left++, right--); // Use 'right--' instead of 'end--'
        }
    }

    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2; // Start from second to last element

        // 1. Find the pivot: first element from right that is smaller than its neighbor
        // Fixed: Loop condition and index to prevent OutOfBounds
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // 2. If pivot is found (array is not entirely in descending order)
        if (i >= 0) {
            int j = n - 1;
            // Find the successor: first element from right larger than arr[i]
            while (arr[j] <= arr[i]) {
                j--;
            }
            // 3. Swap pivot and successor
            swap(arr, i, j);
        }

        // 4. Reverse the suffix to get the smallest possible arrangement
        // If i was -1, this reverses the whole array (correct behavior for last permutation)
        reverse(arr, i + 1, n - 1);
    }
}
