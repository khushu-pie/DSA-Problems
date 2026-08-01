//need to find the maximum repeating elements from an array by creating a frequency array
//TC:O(n+k) and SC:O(k)

import java.util.*;

class Repeating_elements {

    static int maxRepeating(int k, int[] arr)
    {
        // Frequency array of size k
        int[] freq = new int[k];

        // Count frequency of each element
        for (int i = 0; i < arr.length; i++)
            freq[arr[i]]++;

        int maxFreq = 0;
        int result = 0;

        // Find element with maximum frequency
        // If tie choose smallest element
        for (int i = 0; i < k; i++)
        {
            if (freq[i] > maxFreq)
            {
                maxFreq = freq[i];
                result = i;
            }
            else if (freq[i] == maxFreq && i < result)
            {
                result = i;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int k = 71;

        int[] arr = {
            35, 4, 52, 55, 28, 68, 39, 67, 38, 29,
            26, 11, 69, 10, 16, 56, 10, 61, 70, 27,
            65, 53
        };

        System.out.println(maxRepeating(k, arr));
    }
}