//3Sum problem in java->finding triplets that sum upto 0 from a given integer array
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;//to avoid looping back on same values
            int j=i+1,k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                } else if(sum>0){
                    k--;
                } else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){//same as why we did for i loop 
                        j++;
                    }
                     while(j<k && nums[k]==nums[k+1]){//same as why we did for i loop 
                        k--;
                    }
                }
            }
        }
        return ans;
        
    }
}
