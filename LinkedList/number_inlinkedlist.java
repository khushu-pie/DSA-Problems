/*You are given two linked lists representing two large positive numbers. The linked lists represent these two numbers, subtract the smaller number from the larger one and return the head of the linked list representing the result.

The linked list does not contain leading zeros, except for the number zero itself.

Examples: 

Input: l1 = 1 -> 0 -> 0 -> NULL,  l2 = 1 -> NULL 
Output: 9->9->NULL 
Explanation: Number represented as lists are 100 and 1, so 100 - 1 is 99  

Input: l1 = 7-> 8 -> 6 -> NULL,  l2 = 7 -> 8 -> 9 NULL 
Output: 3->NULL 
Explanation: Number represented as lists are 786 and  789, so 789 - 786 is 3,  as the smaller value is subtracted from the larger one.  */
/*Approach
To handle arbitrarily large numbers without overflow, perform digit-by-digit subtraction after reversing the lists:

Trim leading zeros from input lists.

Determine which number is larger by comparing list lengths (and digit values if lengths are equal).

Reverse both lists so subtraction starts from the least significant digit (ones place).

Subtract digit-by-digit using standard carry/borrow rules.

Reverse the output list and trim any remaining leading zeros. */
class Node { 
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
    // Helper method to print the linked list
    public static void printList(Node node) {
        if (node == null) {
            System.out.println("0");
            return;
        }
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
}
public class number_inlinkedlist {
    // Helper method to remove unneeded zeros from the front of the list (e.g., 0042 -> 42)
    private static Node trimLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    // Helper method to count total nodes in a list
    private static int getLength(Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    // Helper method to reverse a linked list in-place
    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev; // Reverse pointer direction
            prev = curr;      // Advance prev
            curr = nextTemp;  // Advance curr
        }
        return prev; // New head of reversed list
    }

    // Main subtraction method: calculates (head1 - head2) or (head2 - head1) as a positive result
    static Node subLinkedList(Node head1, Node head2) {
        // Step 1: Strip leading zeros from inputs (e.g., 00123 -> 123)
        head1 = trimLeadingZeros(head1);
        head2 = trimLeadingZeros(head2);

        // Edge case checks: if inputs become empty, handle zero cases
        if (head1 == null && head2 == null) return new Node(0);
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // Step 2: Ensure l1 points to the LARGER number and l2 to the SMALLER number
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        Node l1 = head1;
        Node l2 = head2;

        if (len1 < len2) {
            l1 = head2;
            l2 = head1;
        } else if (len1 == len2) {
            // If lengths are equal, compare digit by digit from left to right
            Node c1 = head1, c2 = head2;
            while (c1 != null && c1.data == c2.data) {
                c1 = c1.next;
                c2 = c2.next;
            }
            
            // If both numbers are completely identical, subtraction yields 0
            if (c1 == null) return new Node(0);

            // Swap if head2 is larger than head1
            if (c1.data < c2.data) {
                l1 = head2;
                l2 = head1;
            }
        }

        // Step 3: Reverse both lists to start subtracting from the least significant digit (ones place)
        l1 = reverse(l1);
        l2 = reverse(l2);

        Node dummy = new Node(0); // Dummy node to build result list
        Node curr = dummy;
        int borrow = 0;          // Track borrowed value across digit columns

        // Step 4: Perform digit-by-digit column subtraction
        while (l1 != null) {
            int d1 = l1.data;
            int d2 = (l2 != null) ? l2.data : 0; // If l2 runs out of digits, treat missing digit as 0

            // Subtract current digit of l2 and any previous borrow from d1
            int diff = d1 - d2 - borrow;

            // Handle underflow by borrowing 10 from the next column
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            // Append calculated digit to result list
            curr.next = new Node(diff);
            curr = curr.next;

            // Advance list pointers
            l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Step 5: Reverse result list back to normal (most significant digit first)
        Node result = reverse(dummy.next);

        // Step 6: Remove any newly introduced leading zeros (e.g., 1000 - 999 = 0001 -> 1)
        result = trimLeadingZeros(result);

        // Return result, fallback to single 0 if result is null
        return (result == null) ? new Node(0) : result;
    }

    // Helper method to convert an array of integers into a Linked List
    private static Node createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Main function to run test cases
    public static void main(String[] args) {
        System.out.println("--- Subtraction of Two Linked Lists ---");

        // Test Case 1: 1000 - 99 = 901
        Node head1 = createList(new int[]{1, 0, 0, 0});
        Node head2 = createList(new int[]{9, 9});
        
        System.out.print("Num 1: ");
        Node.printList(head1);
        System.out.print("Num 2: ");
        Node.printList(head2);
        
        Node result1 = subLinkedList(head1, head2);
        System.out.print("Result (1000 - 99): ");
        Node.printList(result1);
        System.out.println();

        // Test Case 2: Identical numbers (1234 - 1234 = 0)
        Node head3 = createList(new int[]{1, 2, 3, 4});
        Node head4 = createList(new int[]{1, 2, 3, 4});
        
        System.out.print("Num 1: ");
        Node.printList(head3);
        System.out.print("Num 2: ");
        Node.printList(head4);

        Node result2 = subLinkedList(head3, head4);
        System.out.print("Result (1234 - 1234): ");
        Node.printList(result2);
        System.out.println();

        // Test Case 3: Leading zeros in inputs (00100 - 07 = 93)
        Node head5 = createList(new int[]{0, 0, 1, 0, 0});
        Node head6 = createList(new int[]{0, 7});

        System.out.print("Num 1: ");
        Node.printList(head5);
        System.out.print("Num 2: ");
        Node.printList(head6);

        Node result3 = subLinkedList(head5, head6);
        System.out.print("Result (00100 - 07): ");
        Node.printList(result3);
    }
}
