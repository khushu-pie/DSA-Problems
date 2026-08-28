/*Given a sorted array arr[] of unique integers, an integer k, and a target value x. Return exactly k elements from the array closest to x, excluding x if it exists.

An element a is closer to x than b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a > b (i.e., prefer the larger element if tied)
Return the k closest elements in order of closeness.
*/
import java.util.ArrayList;

public class K_closestelement {
    public ArrayList<Integer> findKClosest(int[] arr, int k, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        
        // Step 1: Binary search to find the crossover point (first element >= x)
        int right = findCrossover(arr, 0, n - 1, x);
        int left = right - 1;

        // Step 2: If x is present at 'right', exclude x itself from results
        if (right < n && arr[right] == x) {
            right++;
        }

        // Step 3: Expand outward using 2 pointers to pick the k closest elements
        while (res.size() < k && (left >= 0 || right < n)) {
            
            // If right boundary is exhausted, take from left
            if (right >= n) {
                res.add(arr[left]);
                left--;
            }
            // If left boundary is exhausted, take from right
            else if (left < 0) {
                res.add(arr[right]);
                right++;
            }
            // Compare absolute differences of elements at left and right pointers
            else {
                int diffLeft = Math.abs(arr[left] - x);
                int diffRight = Math.abs(arr[right] - x);

                // Prefer smaller distance. On tie (diffLeft == diffRight), pick larger value (arr[right])
                if (diffRight < diffLeft) {
                    res.add(arr[right]);
                    right++;
                } else if (diffLeft < diffRight) {
                    res.add(arr[left]);
                    left--;
                } else {
                    // Tie-breaker: arr[right] is larger because array is sorted
                    res.add(arr[right]);
                    right++;
                }
            }
        }

        return res;
    }

    // Helper method: Binary search to find the first index where arr[index] >= x
    private int findCrossover(int[] arr, int low, int high, int x) {
        // Base cases
        if (arr[high] <= x) return high;
        if (arr[low] >= x) return low;

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1; // Try to find a smaller index >= x
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Main method for testing and dry-run
    public static void main(String[] args) {
        K_closestelement sol = new K_closestelement();

        // Sample Test Case
        int[] arr = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int k = 4;
        int x = 35;

        System.out.println("Input Array:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("\nk = " + k + ", x = " + x);

        ArrayList<Integer> result = sol.findKClosest(arr, k, x);

        System.out.println("\nK Closest Elements:");
        System.out.println(result);
    }
}
