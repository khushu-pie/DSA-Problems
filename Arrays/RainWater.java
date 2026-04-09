//both are better and optimal approach with TC:O(n) SC:O(1)
import java.util.*;
class Solution {
    public int trap(int[] height) {
        // int n=height.length;
        // int lmax[]=new int[n];
        // int rmax[]=new int[n];
        
        
        // int ans=0;
        // if(n<=2){
        //     return 0;
        // }
        // lmax[0]=height[0];
        // for(int i=1;i<n;i++){
        //     lmax[i]=Math.max(lmax[i-1],height[i]);
        // }
        // rmax[n-1]=height[n-1];
        // for(int i=n-2;i>=0;i--){
        //     rmax[i]=Math.max(rmax[i+1],height[i]);
        // }
        // for(int i=0;i<n;i++){
        //     int capacity=Math.min(lmax[i],rmax[i]);
        //     ans+=capacity-height[i];
        // }
        // return ans;
        int n=height.length;
        int ans=0;
        int l=0;
        int r=n-1;
        int lmax=0,rmax=0;
        while(l<r){
            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[r]);
            if(lmax<rmax){
                ans+=lmax-height[l];
                l++;
            } else{
                ans+=rmax-height[r];
                r--;
            }
        }
        return ans;
        
    }
}
