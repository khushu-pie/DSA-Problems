public class RemoveNthFromEnd {
   

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Removes the nth node from the end of the list.
     * @param head Head node of the linked list
     * @param n Position from the end (1-indexed)
     * @return Head node of the modified linked list
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to handle edge cases like removing the first element
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Advance fast pointer so that the distance between fast and slow is n + 1
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow is now right before the target node; remove it
        slow.next = slow.next.next;

        return dummy.next;
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

        int n = 2; // Remove the 2nd node from the end (node with value 4)

        System.out.print("Original List: ");
        printList(head);

        ListNode result = removeNthFromEnd(head, n);

        System.out.print("Modified List: ");
        printList(result);
    }
}

