//a good tricky question used min heap to reduce time
import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
    //    PriorityQueue<Integer> heap=new PriorityQueue();
    //    for(int num:nums){
    //     if(heap.size()<k){
    //         heap.add(num);
    //     } else{
    //         if(num>heap.peek()){
    //             heap.poll();
    //             heap.add(num);
    //         }
    //     }
    //    }
    //     return heap.peek();
    Arrays.sort(nums);
    return nums[nums.length-k];
       }
    
}
