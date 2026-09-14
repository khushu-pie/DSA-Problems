/*Given a singly linked list with every node having an additional arbitrary pointer that currently points to NULL. 
The task is to make the arbitrary pointer point to the next higher-value node. */
/*Using Merge Sort - O(nlogn) Time and O(n) Space
The approach involves using a modified Merge Sort for linked list while maintaining the original sequence and linking each node to the next higher value using an auxiliary arbit pointer.
 Initially, the arbit pointer of each node is set to point to the next node. 
 The list is recursively split into smaller sections, which are then sorted and merged back together.
  During merging, the arbit pointers are updated to point to the next higher value node.
   This method efficiently sorts the list and adjusts the arbit pointers to maintain the desired order without altering the original list structure.
    */
class Node {
    int data;
    Node next;
  
    // Pointer to next higher node
    Node arbit; 

    Node(int x) {
        data = x;
        next = null;
        arbit = null;
    }
}
public class Arbit_pointer {
    // Function to merge two sorted lists
    public static Node SortedMerge(Node left, Node right) {
  
        // If one list is empty, return the other
        if (left == null) return right;
        if (right == null) return left;

        Node result = null;
        Node curr = null;

        // Initialize result with the smaller node
        if (left.data <= right.data) {
            result = left;
            left = left.arbit;
        } else {
            result = right;
            right = right.arbit;
        }
        curr = result;

        // Merge the two lists
        while (left != null && right != null) {
            if (left.data <= right.data) {
                curr.arbit = left;
                left = left.arbit;
            } else {
                curr.arbit = right;
                right = right.arbit;
            }
            curr = curr.arbit;
        }

        // Attach remaining nodes
        curr.arbit = (left != null) ? left : right;
        return result;
    }

    // Function to split the list into two halves
    public static Node split(Node head) {
  
        // If list is empty or has one node
        if (head == null || head.arbit == null) return null;

        Node slow = head;
        Node fast = head.arbit;

        // Move slow and fast pointers to find middle
        while (fast != null && fast.arbit != null) {
            slow = slow.arbit;
            fast = fast.arbit.arbit;
        }

        // Split the list into two halves
        Node second = slow.arbit;
        slow.arbit = null;
        return second;
    }

    // Recursive merge sort for arbit pointers
    public static Node MergeSort(Node head) {
  
        // If list is empty or has one node
        if (head == null || head.arbit == null) return head;

        // Split the list into two halves
        Node left = head;
        Node right = split(head);

        // Recursively sort both halves
        left = MergeSort(left);
        right = MergeSort(right);

        // Merge the two sorted halves
        return SortedMerge(left, right);
    }

    // Function to populate arbit pointers
    public static Node populateArbit(Node head) {
        Node curr = head;

        // Initialize arbit pointers to next nodes
        while (curr != null) {
            curr.arbit = curr.next;
            curr = curr.next;
        }

        // Sort the list using arbit pointers
        return MergeSort(head);
    }

    public static void printListArbit(Node node) {
        Node curr = node;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.arbit;
        }
        System.out.println();
    }

    public static void main(String[] args) {
  
        // Create a hardcoded linked list
        // List: 5 -> 10 -> 2 -> 3
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        // Populate arbit pointers to next higher node
        head = populateArbit(head);

        printListArbit(head);
    }
}
