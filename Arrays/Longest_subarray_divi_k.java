// User function Template for Java
import java.util.HashMap;
class Longest_subarray_divi_k {
    int longestSubarrayDivK(int[] arr, int k) {
        int n = arr.length;
        // Map stores <Remainder, First Appearance Index>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: a remainder of 0 "starts" at index -1
        map.put(0, -1);
        
        int maxLen = 0;
        long currSum = 0; // Use long to prevent overflow during summation

        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            
            // Calculate remainder
            int rem = (int)(currSum % k);
            
            // Handle negative remainders in Java (e.g., -1 % 3 = -1, we want 2)
            if (rem < 0) {
                rem += k;
            }
            
            // If we have seen this remainder before, calculate the distance
            if (map.containsKey(rem)) {
                int prevIndex = map.get(rem);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                // Only store the first occurrence to keep the subarray as long as possible
                map.put(rem, i);
            }
        }
        
        return maxLen;
    }
}
