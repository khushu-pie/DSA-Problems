// Java program to detect and remove loop using Floyd's Cycle Detection Algorithm
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class RemoveLoop {

    // Function to detect and remove a loop from the linked list
    static void removeLoop(Node head) {

        // If list is empty or has only one node without loop
        if (head == null || head.next == null)
            return;

        Node slow = head, fast = head;

        // Move slow and fast 1 and 2 steps ahead respectively
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        // If loop exists
        if (slow == fast) {
            slow = head;

            // CASE 1: Loop starting point is NOT the head node
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                // fast.next is the starting node of the loop; break the loop
                fast.next = null;
            } 
            // CASE 2: Loop starting point IS the head node (Circular List)
            else {
                while (fast.next != slow) {
                    fast = fast.next;
                }
                // fast is now the tail node; break the loop
                fast.next = null;
            }
        }
    }

    // Helper method to print the linked list
    static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println(" -> null");
    }

    public static void main(String[] args) {

        // --- Test Case 1: Loop starts at an inner node (1 -> 3 -> 4 -> 3 ...) ---
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(4);
        head1.next.next.next = head1.next; // Loop back to node with value 3

        System.out.println("Test Case 1 (Inner loop removed):");
        removeLoop(head1);
        printList(head1);

        // --- Test Case 2: Circular loop starting at the head node (1 -> 2 -> 3 -> 1 ...) ---
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = head2; // Loop back to head

        System.out.println("\nTest Case 2 (Head loop/Circular list removed):");
        removeLoop(head2);
        printList(head2);
    }
}