/*Given an array arr[] and an integer k, return the count of distinct numbers in all windows of size k. 
Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output: [3, 4, 4, 3]
Explanation: First window is [1, 2, 1, 3], count of distinct numbers is 3.
                       Second window is [2, 1, 3, 4] count of distinct numbers is 4.
                       Third window is [1, 3, 4, 2] count of distinct numbers is 4.
                       Fourth window is [3, 4, 2, 3] count of distinct numbers is 3. */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class CountDistinctElementsinWindow {

public static ArrayList<Integer> countDistinct(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Edge cases: empty array or invalid window size
        if (arr == null || arr.length == 0 || k > arr.length || k <= 0) {
            return result;
        }

        // Hash map to store element frequency in the current window
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Process the first window of size k
        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        // Add distinct count for the first window
        result.add(freqMap.size());

        // Step 2: Slide the window from index k to arr.length - 1
        for (int i = k; i < arr.length; i++) {
            
            // --- Remove the outgoing element (left side of window) ---
            int outgoing = arr[i - k];
            if (freqMap.get(outgoing) == 1) {
                freqMap.remove(outgoing); // Remove key if count drops to 0
            } else {
                freqMap.put(outgoing, freqMap.get(outgoing) - 1);
            }

            // --- Add the incoming element (right side of window) ---
            int incoming = arr[i];
            freqMap.put(incoming, freqMap.getOrDefault(incoming, 0) + 1);

            // Record the number of distinct elements in the current window
            result.add(freqMap.size());
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        ArrayList<Integer> result = countDistinct(arr, k);
        for (int ele : result) {
            System.out.print(ele + " ");
        }
    }
}