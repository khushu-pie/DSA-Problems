/*Given an array arr[] consisting of both positive and negative integers, find the length of the longest subarray whose elements sum is zero.
A subarray is a contiguous part of an array, formed by selecting one or more consecutive elements while maintaining their original order.
Input: arr[] = [15, -2, 2, -8, 1, 7, 10]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].
Main coe logic for using hashmap is
The idea is based on the observation that for two different indices i and j (where j > i) if the prefix sums Si and Sj are equal, it means that the sum of the elements between indices i+1 and j is zero. This is because:

Sj - Si = arr[i+1] + arr[i+2] + …... + arr[j]
If Si = Sj, then:  arr[i+1] + arr[i+2] + …... + arr[j] = 0. [ The subarray sum from i+1 to j is 0. ]
 */

import java.util.HashMap;

public class Longestsubarraylength_0sum {
    public static int maxLength(int arr[]) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);//map that stores prefixsum and index where the sum occurred first time
        int prefixsum=0;
        int maxlen=0;
        for(int i=0;i<arr.length;i++){
            prefixsum+=arr[i];
            if(map.containsKey(prefixsum)){
                int previdx=map.get(prefixsum);//to get the index where that sum was first found
                maxlen=Math.max(maxlen,i-previdx);
            } else{
                map.put(prefixsum,i);
            }
        }
        return maxlen; 
    }
     public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10};
        System.out.println(maxLength(arr));
    }
}
