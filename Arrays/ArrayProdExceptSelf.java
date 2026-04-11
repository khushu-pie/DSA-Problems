class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        int[] ans=new int[n];
        //prefix array
        prefix[0]=1;
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }
        //suffix array
        suffix[n-1]=1;
        for(int i=n-2;i>=0;i--){
            suffix[i]=suffix[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            ans[i]=prefix[i]*suffix[i];
        }
        return ans;
    }
}
//in this approch TC:O(3*n)->O(n) and SC:O(n*2)-> becoz creating new prefix and suffix array
//so below is optimal approch with SC:O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        
        int[] ans=new int[n];
        //prefix array
        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
        //suffix array
        int suffix=1;
        for(int i=n-2;i>=0;i--){
            suffix*=nums[i+1];
            ans[i]*=suffix;
        }
        
        return ans;
    }
}
