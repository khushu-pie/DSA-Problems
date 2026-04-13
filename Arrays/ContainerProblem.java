//leetcode problem no.11 -> Container with most water
class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int n=height.length;
      //brute force approach
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         int width=j-i;
        //         int h=Math.min(height[i],height[j]);
        //         int area=width*h;
        //         ans=Math.max(ans,area);
        //     }
        // }
        // return ans;
        int left=0;
        int right=n-1;
        while(left<right){
            int width=right-left;
            int h=Math.min(height[right],height[left]);
            int area=width*h;
            ans=Math.max(ans,area);
            if(height[left]<height[right]){
                left++;
            } else{
                right--;
            }
        }
        return ans;
    }
}
