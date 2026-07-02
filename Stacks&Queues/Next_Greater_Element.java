import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Next_Greater_Element {
    
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        
        // Pre-allocate the ArrayList with placeholders (-1) so we can fill it by index
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        
        // Stack to store the INDICES of elements
        Stack<Integer> stack = new Stack<>();
        
        // Traverse the array from left to right
        for (int i = 0; i < n; i++) {
            
            // While stack is not empty and the current element is greater 
            // than the element at the index stored at the top of the stack
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                // Pop the index from the stack
                int indexToUpdate = stack.pop();
                // The current element arr[i] is the next larger element for arr[indexToUpdate]
                res.set(indexToUpdate, arr[i]);
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }
        
        // Any indices left in the stack have no larger element to their right,
        // and they will safely remain as -1 (our default value).
        return res;
    }

    // The main method to execute and test the code
    public static void main(String[] args) {
        // Create an instance of the class
        Next_Greater_Element solver = new Next_Greater_Element();
        
        // Example test case array
        int[] arr = {6, 8, 0, 1, 3};
        
        // Call the method and store the result
        ArrayList<Integer> result = solver.nextLargerElement(arr);
        
        // Print the input and output clearly
        System.out.print("Input Array:  [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("]");
        
        System.out.println("Next Greater: " + result);
    }
}