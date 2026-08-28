//basically an array will be given in which elements will be added one by one and u need to find the greatest ekemt till that insertion and if till now the
//size if array is less than k then return -1 instead
import java.util.ArrayList;
import java.util.PriorityQueue;

public class K_largestelement {
    // Method to find the k-th largest element at each step of the array stream
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        
        // Min-heap to maintain the k largest elements seen so far
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Process each element from the stream
        for (int i = 0; i < arr.length; i++) {
            
            // Add element to heap if it has fewer than k elements
            if (minHeap.size() < k) {
                minHeap.add(arr[i]);
            } else {
                // Replace the root (smallest of top k) if current element is larger
                if (arr[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(arr[i]);
                }
            }
            
            // If we don't have k elements yet, append -1; otherwise, the root is the k-th largest
            if (minHeap.size() < k) {
                res.add(-1);
            } else {
                res.add(minHeap.peek());
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        // Test Case Input
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 4;

        System.out.println("Input Array: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println("\nk = " + k);

        // Call the method
        ArrayList<Integer> result = kthLargest(arr, k);

        // Print the output array list
        System.out.println("\nResulting k-th largest list at each step:");
        System.out.println(result);
    }
}
