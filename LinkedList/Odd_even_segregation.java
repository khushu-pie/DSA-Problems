/*Maintaining Start and End - O(n) Time O(1) Space
The idea is to maintain two separate lists for even and odd nodes using dummy nodes. 
During traversal, append nodes to their respective lists and finally connect the even list to the odd list.

Initialize pointers for even and odd list , say evenStart , evenEnd and oddStart , oddEnd.
Separate nodes into even and odd lists during traversal. 
Link the end of the even list to the start of the odd list.
Update the original list's head to the even list's head. 
*/
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Odd_even_segregation {
    // Function to segregate even and odd nodes
    // and return the head of the new list.
    public static Node divide(Node head) {

        // We create dummy nodes to avoid extra 
        // condition checks in the while loop.
        Node eStart = new Node(0);
        Node oStart = new Node(0);

        // Pointers to the end of the even and odd lists
        Node eEnd = eStart;
        Node oEnd = oStart;

        // Node to traverse the list
        Node curr = head;

        while (curr != null) {
            int val = curr.data;

            // If current value is even, add it to the even list
            if (val % 2 == 0) {
                eEnd.next = curr;
                eEnd = eEnd.next;
            } else { // Else to the odd list
                oEnd.next = curr;
                oEnd = oEnd.next;
            }

            // Move to the next node
            curr = curr.next;
        }

        // Terminate the odd list
        oEnd.next = null;

        // Combine even and odd lists
        eEnd.next = oStart.next;

        // Return the new head of the combined list (even head)
        return eStart.next;
    }

    // Function to print the linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        // Let us create a sample linked list as following
        // 0->1->4->6->9->10->11
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next = new Node(11);

        System.out.print("Original Linked list: ");
        printList(head);

        head = divide(head);

        System.out.print("\nModified Linked list: ");
        printList(head);
    }
}
