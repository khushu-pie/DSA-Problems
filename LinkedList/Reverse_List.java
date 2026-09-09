public class Reverse_List {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // Pointer to store the previous node
        ListNode curr = head; // Pointer to iterate through the list

        while (curr != null) {
            ListNode nextTemp = curr.next; // Store the next node temporarily
            curr.next = prev;              // Reverse the current node's pointer
            prev = curr;                   // Move prev forward
            curr = nextTemp;               // Move curr forward
        }

        return prev; // prev becomes the new head of the reversed list
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

        ListNode reversedHead = reverseList(head);

        System.out.print("Reversed List: ");
        printList(reversedHead);
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}