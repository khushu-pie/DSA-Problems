class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class Reverse_DoublyLinkedList {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node temp = null;

        // Traverse and swap next and prev pointers for every node
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // Advance to the next node (which is now stored in curr.prev)
            curr = curr.prev;
        }

        // temp points to the prev of the last processed node, so temp.prev is the new head
        return temp.prev;
    }

    // Helper method to print the doubly linked list forward
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? " <-> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Constructing doubly linked list: 10 <-> 20 <-> 30 <-> 40
        Node head = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        head.next = n2;
        n2.prev = head;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n4.prev = n3;

        System.out.print("Original List: ");
        printList(head);

        Reverse_DoublyLinkedList sol = new Reverse_DoublyLinkedList();
        head = sol.reverse(head);

        System.out.print("Reversed List: ");
        printList(head);
    }
}
