//gfg problem -> finding kth smallest element from given array
import java.util.*;
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        return arr[k-1];
    }
}
