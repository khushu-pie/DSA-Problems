/*Given a linked list where in addition to the next pointer, each node has a child pointer, which may or may not point to a separate list. 
These child lists may have one or more children of their own to produce a multilevel linked list. 
Given the head of the first level of the list. The task is to flatten the list so that all the nodes appear in a single-level linked list.
Flatten the list in a way that all nodes at the first level should come first, then nodes of the second level, and so on.

Output: 1->4->6->2->5->7->3->8
Explanation: The multilevel linked list is flattened as it has no child pointers. */
/* approach is:
Approach:

To flatten a multilevel linked list, start from the top level and process each node sequentially. For each node, if it has a child node, append this child node to the end of the current list. Continue this process for every node, updating the end of the list accordingly, until all nodes are processed and the list is flattened.

Step by step implementation:

Initialize curr and tail pointer points to head node initially.
Start traversing from the first level and set the tail to the last node.
Start traversing from curr horizontally until curr is not NULL:
If curr->child is not equal to NULL, then append the child list to the end of the resultant list by using tail->next = curr->child.
Traverse the child list horizontally , and set tail to the last node of the child list.
Set curr->child = NULL to remove the link.
Move the curr pointer to the next node in the list.
Return the head node. */
class Node {
    int data;
    Node next, child;

    Node(int x) {
        data = x;
        next = null;
      	child = null;
    }
}
public class Flatten_multilevel_linkedlist {
    static void flattenList(Node head) {

        // Base case
        if (head == null)
            return;

        // Find tail node of first level
        Node tail = head;
        while (tail.next != null)
            tail = tail.next;

        // One by one traverse through all nodes of first level 
        Node curr = head;

        while (curr != null) {

            // If current node has a child
            if (curr.child != null) {

                // then append the child at the end of current list
                tail.next = curr.child;

                // and update the tail to new last node
                Node tmp = curr.child;
                while (tmp.next != null)
                    tmp = tmp.next;
                tail = tmp;

                // Remove link between curr and child node
                curr.child = null;
            }

            // Change current node
            curr = curr.next;
        }
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
      	//Linked List - 
      	// 1 -> 2 -> 3
		// |    |   
		// 4 -> 5   6
		// |
		// 7
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.child = new Node(4);
        head.child.next = new Node(5);
        head.next.next.child = new Node(6);
        head.child.child = new Node(7);

        flattenList(head);
        printList(head);
    }
}
