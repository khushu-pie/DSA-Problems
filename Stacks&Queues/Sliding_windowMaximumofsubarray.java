/*Given an array arr[] of positive integers and an integer k. Find the maximum value for each contiguous subarray of size k.
Return an array of maximum values corresponding to each contiguous subarray.
Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
Output: [3, 3, 4, 5, 5, 5, 6] 
Explanation: 
1st contiguous subarray = [1 2 3] max = 3
2nd contiguous subarray = [2 3 1] max = 3
3rd contiguous subarray = [3 1 4] max = 4
4th contiguous subarray = [1 4 5] max = 5
5th contiguous subarray = [4 5 2] max = 5
6th contiguous subarray = [5 2 3] max = 5
7th contiguous subarray = [2 3 6] max = 6 
*/
/*Approach
Maintain a Deque that stores indices of array elements in a strictly decreasing order of their values.

For each element at index i:

Remove out-of-bound indices: Remove indices from the front of the deque if they fall outside the current window (index <= i - k).

Maintain monotonic property: Remove indices from the back of the deque as long as the element at those indices is smaller than or equal to arr[i]. (Since they are smaller and older, they can never be the maximum in the current or future windows).

Add current index: Push i to the back of the deque.

Record result: Once i >= k - 1 (the first full window is reached), the element at the front of the deque (arr[deque.peekFirst()]) is the maximum for that window.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Sliding_windowMaximumofsubarray {
    public static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        // Base checks
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return result;
        }

        // Deque to store indices of array elements.
        // Elements in the deque will be maintained in decreasing order of their values.
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            
            // 1. Remove elements that are out of the current window of size k
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. Remove elements from the back that are smaller than or equal to current element arr[i]
            //    because they will not be needed as maximums anymore
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // 3. Add current element's index to the back of deque
            deque.offerLast(i);

            // 4. Record the maximum of current window (front of deque) once we reach index k - 1
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;

        System.out.println("Input Array: ");
        for (int num : arr1) System.out.print(num + " ");
        System.out.println("\nWindow Size (k): " + k1);

        ArrayList<Integer> res1 = maxOfSubarrays(arr1, k1);
        System.out.println("Maximum in each window: " + res1);
        // Output: [3, 3, 5, 5, 6, 7]

        System.out.println("----------------------------------------");

        // Test Case 2
        int[] arr2 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k2 = 4;

        System.out.println("Input Array: ");
        for (int num : arr2) System.out.print(num + " ");
        System.out.println("\nWindow Size (k): " + k2);

        ArrayList<Integer> res2 = maxOfSubarrays(arr2, k2);
        System.out.println("Maximum in each window: " + res2);
        // Output: [10, 10, 10, 15, 15, 90, 90]
    }

}
