/* approach:
The idea is to take two pointers, front at the head and last at the tail.
 Compare their values, add the smaller one to the result list, and move the corresponding pointer.
 Repeat until all nodes are processed.
  */
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Sort_bitonic_doublylist {
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Function to sort the doubly linked list
    static Node sortBitonicDLL(Node head) {
        if (head == null || head.next == null) return head;

        // Find the last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Initialize pointers
        Node front = head;
        Node result = null;
        Node tail = null;

        // Process nodes until all are added to the 
      	// result list
        while (front != null && last != null && front != last 
               && last.next != front) {
            Node newNode;

            // Compare the value of the front and last nodes
            if (front.data < last.data) {
                newNode = new Node(front.data);
                front = front.next;
            } else {
                newNode = new Node(last.data);
                last = last.prev;
            }

            // Add the new node to the result list
            if (result == null) {
                result = newNode;
                tail = result;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = tail.next;
            }
        }

        // Handle the case where front and last pointers
      	// meet or cross
        while (front != null && front != last.next) {
            Node newNode = new Node(front.data);
            front = front.next;
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }

        while (last != null && last.next != front) {
            Node newNode = new Node(last.data);
            last = last.prev;
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }

        return result;
    }

    public static void main(String[] args) {
      
        // Create the doubly linked list: 2<->12<->11<->1
        Node head = new Node(2);
        head.next = new Node(12);
        head.next.prev = head;
        head.next.next = new Node(11);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(1);
        head.next.next.next.prev = head.next.next;

        Node sortedHead = sortBitonicDLL(head);
        printList(sortedHead);
    }
}
