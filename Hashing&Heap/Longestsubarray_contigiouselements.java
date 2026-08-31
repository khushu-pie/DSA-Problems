import java.util.Collections;
import java.util.PriorityQueue;

public class Longestsubarray_contigiouselements {
    public static int longestsubarray(int[] arr) {
        // Edge case: empty array has length 0
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        int maxlen = 1; // Minimum length of a non-empty subarray is 1
        int left = 0;   // Left pointer for the sliding window

        // Min-heap to track the smallest element in the current window
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        // Max-heap to track the largest element in the current window
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        // Expand the sliding window using the right pointer
        for (int right = 0; right < n; right++) {
            minheap.add(arr[right]);
            maxheap.add(arr[right]);

            // If absolute difference between maximum and minimum exceeds 1, shrink window
            while (maxheap.peek() - minheap.peek() > 1) {
                // Remove the element at the left pointer from both heaps
                minheap.remove(arr[left]);
                maxheap.remove(arr[left]);
                // Move the left pointer forward
                left++;
            }

            // Update the maximum subarray length found so far
            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
    }
    public static void main(String[] args) {
        int[] arr = {10, 11, 12};
        int res = longestsubarray(arr);
        
        // Output result
        System.out.println("Longest Subarray Length: " + res); // Output: 2 (Subarray [10, 11] or [11, 12])
    }
}
