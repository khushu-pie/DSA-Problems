import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {

    public static Queue<Integer> reverseFirstK(Queue<Integer> queue, int k) {
        // Base case: If queue is empty, k is invalid, or k is 0, no changes needed
        if (queue == null || queue.isEmpty() || k <= 0 || k > queue.size()) {
            return queue;
        }

        Stack<Integer> stack = new Stack<>();
        int size = queue.size();

        // Step 1: Dequeue the first 'k' elements from the queue and push them into the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Pop elements from the stack and enqueue them back to the rear of the queue
        // This effectively reverses the first 'k' elements
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Step 3: Move the remaining (size - k) elements from the front to the rear 
        // This maintains the original order of the rest of the elements
        for (int i = 0; i < (size - k); i++) {
            queue.add(queue.poll());
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        
        // Adding elements to the queue: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
        for (int i = 10; i <= 100; i += 10) {
            queue.add(i);
        }
        
        int k = 5;
        System.out.println("Original Queue: " + queue);
        
        Queue<Integer> modifiedQueue = reverseFirstK(queue, k);
        
        // Expected Output: [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]
        System.out.println("Queue after reversing first " + k + " elements: " + modifiedQueue);
    }
}