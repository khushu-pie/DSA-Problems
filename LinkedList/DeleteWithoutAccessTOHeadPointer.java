public class DeleteWithoutAccessTOHeadPointer {
    static void deleteNode(Node x)
    {

        // Store the next node
        Node temp = x.next;

        // Copy next node's data
        x.data = temp.data;

        // Skip the next node
        x.next = temp.next;
    }

    // Function to print the linked list
    static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(4);
        head.next.next.next = new Node(30);

        Node x = head.next;

        deleteNode(x);

        printList(head);
    }
}
class Node {
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}
