// Definition for singly-linked list node


public class Detect_cycle {

    /**
     * Function to detect if a linked list has a cycle.
     * @param head Head node of the linked list
     * @return true if there is a cycle, false otherwise
     */
    public static boolean hasCycle(ListNode head) {
        // Base case: If list is empty or has only one node without a loop
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize slow (tortoise) and fast (hare) pointers
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list until fast reaches the end or a null reference
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer 1 step forward
            fast = fast.next.next;   // Move fast pointer 2 steps forward

            // If the two pointers meet, a cycle is detected
            if (slow == fast) {
                return true;
            }
        }

        // Fast pointer reached the end, so no cycle exists
        return false;
    }

    public static void main(String[] args) {
        // --- Test Case 1: Linked list with a cycle (3 -> 2 -> 0 -> -4 -> 2 ...) ---
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creating a cycle by connecting node4 to node2 (pos = 1)

        System.out.println("Test Case 1 (Has Cycle): " + hasCycle(node1)); // Expected output: true

        // --- Test Case 2: Linked list without a cycle (1 -> 2 -> null) ---
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println("Test Case 2 (No Cycle): " + hasCycle(head2)); // Expected output: false
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}