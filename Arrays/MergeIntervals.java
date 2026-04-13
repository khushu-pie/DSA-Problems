import java.util.*;
class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
      
        // Arrays.sort(arr);
        // int n=arr.length;
        // ArrayList<int[]> ans=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     int start=arr[i][0];
        //     int end=arr[i][1];
        //     if(!ans.isEmpty() && end<=ans.get(ans.size()-1)[1]){
        //         continue;
        //     }
        //     for(int j=i+1;j<n;j++){
        //         if(arr[j][0]<=end){
        //             end=Math.max(end,arr[j][1]);
        //         } else{
        //             break;
        //         }
        //     }
        //     ans.add(new int[]{start,end});
        // }
        // return ans;
        int n = arr.length;
        //if (n <= 1) return Arrays.asList(arr);

        // 1. Sort by the start time (first element of each sub-array)
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> ans = new ArrayList<>();

        // 2. Iterate through sorted intervals
        for (int i = 0; i < n; i++) {
            // If list is empty or current interval does not overlap with the last one
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(new int[]{arr[i][0], arr[i][1]});
            } 
            // If there is an overlap, merge by updating the end time of the last interval
            else {
                int[] lastInterval = ans.get(ans.size() - 1);
                lastInterval[1] = Math.max(lastInterval[1], arr[i][1]);
            }
        }

        return ans;
    }
}
