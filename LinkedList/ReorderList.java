/*Find the Middle of the Linked List:Use the Slow and Fast Pointer technique (Tortoise and Hare).
slow moves 1 step at a time, fast moves 2 steps at a time.
When fast reaches the end, slow will be at the midpoint of the list.
Reverse the Second Half:
Split the list at the midpoint into two halves.
Reverse the pointers of the second half iteratively .
Merge the Two Halves Alternately:
Interleave nodes from the first half and the reversed second half one by one using temporary pointers.
Step-by-Step VisualizationFor list: 1 -> 2 -> 3 -> 4 ->5
Step 1: Find MiddleFirst Half: 1 -> 2 -> 3
Second Half: 4 -> 5
 Step 2: Reverse Second HalfFirst Half: 1 -> 2 -> 3 -> null
 Reversed Second Half: 5 -> 4 -> null
 Step 3: Interleave/Merge1 -> 5 -> 2 -> 4 -> 3 
 */

public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Reorders the list in-place to L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 ...
     * @param head Head node of the linked list
     */
    public static void reorderList(ListNode head) {
        // Base case: If the list is empty or has only 1 or 2 nodes, no reordering is needed
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // STEP 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow now points to the middle node. Split the list into two halves.
        ListNode secondHalfHead = slow.next;
        slow.next = null; // Break the connection to separate the first half

        // STEP 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = secondHalfHead;

        while (curr != null) {
            ListNode nextTemp = curr.next; // Store next node
            curr.next = prev;              // Reverse the pointer
            prev = curr;                   // Move prev forward
            curr = nextTemp;               // Move curr forward
        }

        // prev is now the head of the reversed second half
        secondHalfHead = prev;

        // STEP 3: Merge/Interleave the two halves
        ListNode firstHalfHead = head;

        while (secondHalfHead != null) {
            // Save the next nodes to prevent losing pointers during re-linking
            ListNode temp1 = firstHalfHead.next;
            ListNode temp2 = secondHalfHead.next;

            // Connect first half node to second half node
            firstHalfHead.next = secondHalfHead;
            // Connect second half node to next first half node
            secondHalfHead.next = temp1;

            // Advance pointers for the next iteration
            firstHalfHead = temp1;
            secondHalfHead = temp2;
        }
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Constructing list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        reorderList(head);

        System.out.print("Reordered List: ");
        printList(head);
    }
}
