/* The idea is to traverse the linked list once using a flag to maintain the zig-zag pattern.
 If the current pair does not satisfy the required relation (≤ or ≥), swap their data values and flip the flag for the next pair.

Let us understand with an example:
Input: head: 11 -> 15 -> 20 -> 5 -> 10
Compare 11 and 15 (<= needed), condition satisfied.

Compare 15 and 20 (>= needed), swap → 11 -> 20 -> 15 -> 5 -> 10
Compare 15 and 5 (<= needed), swap → 11 -> 20 -> 5 -> 15 -> 10
Compare 15 and 10 (>= needed), condition satisfied.
Final List: 11 -> 20 -> 5 -> 15 -> 10
*/
class Node {
    public int data;
    public Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
};
public class ReverseLinkedList_zigzagPattern {
    static Node zigZag(Node head)
    {

        boolean flag = true;

        // Traverse linked list starting from head.
        Node current = head;

        while (current!= null && current.next!= null) {

            if (flag) {

                // flag == true indicates next element
                // should be larger than current
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }
            else {

                // flag == false indicates next element
                // should be smaller than current
                if (current.data < current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }

            current = current.next;

            // Flip flag for reverse checking
            flag = !flag;
        }

        return head;
    }

    // Driver code
    public static void main(String[] args)
    {

        // LinkedList: 11->15->20->5->10
        Node head = new Node(11);
        head.next = new Node(15);
        head.next.next = new Node(20);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(10);

        head = zigZag(head);

        // Print list
        Node current = head;
        while (current!= null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
