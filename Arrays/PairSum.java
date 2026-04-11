//to find a pair in sorted and rotated array TC:O(n) ans SC:O(1)
class Solution {
    static boolean pairInSortedRotated(int arr[], int target) {
        // Your code here
        int n=arr.length;
        int i;
        for(i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                break;
            }
        }
            int right=i;
            int left=(i+1)%n;
        
        while(left!=right){
            int sum=arr[left]+arr[right];
            if(sum==target){
                return true;
            }
            if(sum<target){
                left=(left+1)%n;
            } else{
                right=(n+right-1)%n;
            }
        }
        return false;
        
    }
}

