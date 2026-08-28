/*Given an array arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost.
 The cost to connect two ropes is the sum of their lengths.
 Return the minimum possible cost. */
import java.util.PriorityQueue;

public class Minimum_cost {

    public static int minCost(int[] arr) {
        // Base case: If there's only 1 rope or no ropes, no cost is incurred
        if (arr == null || arr.length <= 1) {
            return 0;
        }

        // Min-Heap to store all rope lengths (smallest element always at the top)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 1: Add all rope lengths into the Min-Heap
        for (int length : arr) {
            minHeap.add(length);
        }

        int totalCost = 0;

        // Step 2: Continuously combine the two smallest ropes until only 1 rope remains
        while (minHeap.size() > 1) {
            // Extract the two shortest ropes
            int firstSmallest = minHeap.poll();
            int secondSmallest = minHeap.poll();

            // Cost to connect these two ropes
            int currentCost = firstSmallest + secondSmallest;

            // Add the cost to the running total
            totalCost += currentCost;

            // Insert the newly formed rope back into the Min-Heap
            minHeap.add(currentCost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {4, 3, 2, 6};
        System.out.println("Min Cost for [4, 3, 2, 6]: " + minCost(arr1)); // Output: 29

        // Test case 2
        int[] arr2 = {4, 2, 7, 69};
        System.out.println("Min Cost for [4, 2, 7, 69]: " + minCost(arr2)); // Output: 85
    }
}