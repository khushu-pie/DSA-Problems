// User function Template for Java
import java.util.Collections;
class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        int min=Integer.MAX_VALUE;
        Collections.sort(arr);
        for(int i=0;i+m-1<arr.size();i++){
            int diff=arr.get(i+m-1)-arr.get(i);
            if(diff<min){
                min=diff;
            }
        }
        return min;
    }
}
