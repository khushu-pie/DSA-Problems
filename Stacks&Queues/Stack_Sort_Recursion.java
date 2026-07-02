import java.util.Stack;

public class Stack_Sort_Recursion {

    // Main recursive function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // Base case: If stack is empty, it is already sorted
        if (stack.isEmpty()) {
            return;
        }

        // Remove the top element
        int top = stack.pop();

        // Sort the remaining stack recursively
        sortStack(stack);

        // Insert the popped element back into the sorted stack in its correct position
        insertInSortedOrder(stack, top);
    }

    // Helper recursive function to insert an element into its sorted position
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base case: If stack is empty OR the top element is smaller than/equal to the element,
        // we can safely push the element on top (maintaining smallest at bottom, largest at top)
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // If the top element is GREATER than our element, it's out of place.
        // Hold onto this top element...
        int top = stack.pop();

        // Recursively insert our element into the remaining stack
        insertInSortedOrder(stack, element);

        // Put the held element back on top
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(34);
        st.push(3);
        st.push(31);

        System.out.println("Original Stack (top to bottom): " + st);
        sortStack(st);
        System.out.println("Sorted Stack   (top to bottom): " + st);
    }
}