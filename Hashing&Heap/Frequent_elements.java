import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

class Frequent_elements {
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies of each number
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Use a Min-Heap based on frequency
        // (a, b) -> freq.get(a) - freq.get(b) sorts elements by lowest frequency first
        //if freq.get(a)<greq.get(b) then it will be negative and a will be closer to top of the heap and will be removed when polled from heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)
        );
        
        // Step 3: Keep the heap size exactly at k
        for (int num : freq.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Removes the least frequent element
            }
        }
        
        // Step 4: Convert the remaining heap elements to an array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        
        return result;
    }
    public static void main(String[] args){
        int[] arr={1,1,1,2,2,3};
        int k=2;
        System.out.println(Arrays.toString(topKFrequent(arr,k)));
    }
}