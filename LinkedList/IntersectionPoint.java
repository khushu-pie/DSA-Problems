/*The idea is to use hashing to store all the nodes of the first list in a hash set and then iterate over second list checking if the node is present in the set. If we find a node which is present in the hash set, we return the node.
 More optimised approach will be by using two pointers:
 */



class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}
public class IntersectionPoint {
    // static Node intersectPoint(Node head1, Node head2) {
    //     HashSet<Node> visNodes = new HashSet<>();

    //     // Traverse the first list and store all nodes in a set
    //     Node curr1 = head1;
    //     while (curr1 != null) {
    //         visNodes.add(curr1);
    //         curr1 = curr1.next;
    //     }

    //     // Traverse the second list and check if any node is
    //     // in the set
    //     Node curr2 = head2;
    //     while (curr2 != null) {
    //         if (visNodes.contains(curr2)) {
              	
    //           	// Intersection point found
    //             return curr2; 
    //         }
    //         curr2 = curr2.next;
    //     }

    //     return null;
    // }

    // public static void main(String[] args) {

    //     // creation of first list: 10 -> 15 -> 30
    //     Node head1 = new Node(10);
    //     head1.next = new Node(15);
    //     head1.next.next = new Node(30);

    //     // creation of second list: 3 -> 6 -> 9 -> 15 -> 30
    //     Node head2 = new Node(3);
    //     head2.next = new Node(6);
    //     head2.next.next = new Node(9);

    //     // 15 is the intersection point
    //     head2.next.next.next = head1.next;

    //     Node interPt = intersectPoint(head1, head2);

    //     if (interPt == null)
    //         System.out.println("-1");
    //     else
    //         System.out.println(interPt.data);
    // }
    static Node intersectPoint(Node head1, Node head2){

        Node ptr1 = head1;
        Node ptr2 = head2;

        if (ptr1 == null || ptr2 == null)
            return null;

        // traverse through the lists until both
        // pointers meet
        while (ptr1 != ptr2) {
          
            // move to the next node in each list and if the one 
            // pointer reaches NULL, start from the other linked list
            ptr1 = (ptr1 != null) ? ptr1.next : head2;
            ptr2 = (ptr2 != null) ? ptr2.next : head1;
        }

        return ptr1;
    }

    public static void main(String[] args) {
      
        // creation of first list: 10 -> 15 -> 30
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

        // creation of second list: 3 -> 6 -> 9 -> 15 -> 30
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);
      
        // 15 is the intersection point
        head2.next.next.next = head1.next;

        Node interPt = intersectPoint(head1, head2);

        if (interPt == null)
            System.out.println("-1");
        else
            System.out.println(interPt.data);
    }
}
