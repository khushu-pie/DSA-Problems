import java.util.HashSet;
//sliding window
public class LengthOfDistictSubarray {
    public static long sumOfLengthsOfDistinctSubarrays(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        long MOD = 1000000007L; // 10^9 + 7

        // HashSet to maintain distinct elements in current window
        HashSet<Integer> set = new HashSet<>();

        int left = 0;

        // Expand the right pointer to increase window size
        for (int right = 0; right < n; right++) {

            // If duplicate found, shrink window from left until element is removed
            while (set.contains(arr[right])) {
                set.remove(arr[left]);
                left++;
            }

            // Add current element into set
            set.add(arr[right]);

            // Number of distinct subarrays ending at index 'right'
            long windowLength = right - left + 1;

            // Sum of lengths of all distinct subarrays ending at index 'right':
            // Lengths are 1, 2, ..., windowLength, so sum is windowLength * (windowLength + 1) / 2
            long currentContribution = (windowLength * (windowLength + 1) / 2) % MOD;

            // Accumulate total sum modulo 10^9 + 7
            totalSum = (totalSum + currentContribution) % MOD;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        // Subarrays with distinct elements:
        // [1] (len 1), [2] (len 1), [3] (len 1), 
        // [1,2] (len 2), [2,3] (len 2), [1,2,3] (len 3)
        // Sum of lengths = 1 + 1 + 1 + 2 + 2 + 3 = 10

        long res = sumOfLengthsOfDistinctSubarrays(arr);
        System.out.println("Sum of lengths of distinct subarrays: " + res);
    }
}
/*
this is basic approch 
public static long sumOfLengthsOfDistinctSubarraysNaive(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        long MOD = 1000000007L; // 10^9 + 7

        // Outer loop to pick starting point of subarray
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();

            // Inner loop to pick ending point of subarray
            for (int j = i; j < n; j++) {

                // If current element is already in the set, a duplicate exists.
                // Stop checking further subarrays starting from 'i'.
                if (set.contains(arr[j])) {
                    break;
                }

                // Add element to set as it is distinct
                set.add(arr[j]);

                // Calculate length of valid distinct subarray arr[i...j]
                long currentLength = j - i + 1;

                // Add length to total sum using modulo arithmetic
                totalSum = (totalSum + currentLength) % MOD;
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};

        // All subarrays for [1, 2, 1]:
        // [1]       -> Distinct, length = 1
        // [1, 2]    -> Distinct, length = 2
        // [1, 2, 1] -> Invalid (duplicate 1)
        // [2]       -> Distinct, length = 1
        // [2, 1]    -> Distinct, length = 2
        // [1]       -> Distinct, length = 1
        //
        // Total Sum of lengths = 1 + 2 + 1 + 2 + 1 = 7

        long res = sumOfLengthsOfDistinctSubarraysNaive(arr);
        System.out.println("Sum of lengths of distinct subarrays: " + res);
    } */
