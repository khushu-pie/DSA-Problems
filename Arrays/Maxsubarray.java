//Kadane's algorithm-optimised approach
import java.util.*;
class Maxsubarray {
    public int maxSubArray(int[] nums) {
        int currsum=0;
        int maxsum = -1_000_000_000;
        for(int i=0;i<nums.length;i++){
            currsum+=nums[i];
            maxsum=Math.max(maxsum,currsum);
            if(currsum<0){
                currsum=0;
            }
        }
        return maxsum;
    }
}
