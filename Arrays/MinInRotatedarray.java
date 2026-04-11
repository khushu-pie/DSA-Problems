//TC:O(log n) SP:O(1)
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int i;
        for(i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                break;
            }
        }
        int large=i;
        int small=(i+1)%n;
        return nums[small];
    }
}
