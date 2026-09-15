import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Merge_ksortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case: return null if input array is empty or null
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-heap initialized with a custom comparator to sort nodes by their integer values
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head node of each non-empty linked list into the min-heap
        for (ListNode node : lists) {
            if (node != null) {
                minheap.add(node);
            }
        }

        // Dummy node acts as a starting anchor for the merged list
        ListNode result = new ListNode(0);
        
        // Pointer to build the merged linked list step-by-step
        ListNode curr = result; 

        // Extract the smallest node and process until the heap is empty
        while (!minheap.isEmpty()) {
            // Remove the node with the smallest value currently in the min-heap
            ListNode smallest = minheap.poll();
            
            // Attach the smallest node to the end of our merged list
            curr.next = smallest;
            
            // Move our builder pointer forward to the newly attached node
            curr = curr.next;

            // If the extracted node has a next node, push that next node into the min-heap
            if (smallest.next != null) {
                minheap.add(smallest.next);
            }
        }

        // Return the actual head of the merged linked list (skipping the dummy node)
        return result.next;
    }



    // Helper method to print the elements of a linked list in readable order
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Construct 3 sorted linked lists for demonstration
        // List 1: 1 -> 4 -> 5
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        
        // List 2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        
        // List 3: 2 -> 6
        ListNode l3 = new ListNode(2, new ListNode(6));

        // Group the input lists into an array
        ListNode[] lists = new ListNode[] { l1, l2, l3 };

        // Execute the merge operation
        Merge_ksortedList sol = new Merge_ksortedList();
        ListNode mergedHead = sol.mergeKLists(lists);

        // Print the output result
        System.out.print("Merged List: ");
        printList(mergedHead);
    }
}

