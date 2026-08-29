import java.util.PriorityQueue;
/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
 */
/* the approach is
Insert the head node of each non-empty linked list into a Min-Heap. The heap orders nodes by their integer values (val).

Extract the node with the smallest value from the heap, attach it to our merged result list, and if that node has a .next pointer, push .next into the min-heap.

Repeat this process until the min-heap is empty. */
// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Merged_Klinkedlists {
    public static ListNode mergeKLists(ListNode[] lists) {
        // Base case: null or empty array of linked lists
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-Heap ordered by node value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Step 1: Add the head of each non-null list to the min-heap
        for (ListNode listHead : lists) {
            if (listHead != null) {
                minHeap.add(listHead);
            }
        }

        // Dummy node to easily build the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Step 2: Extract the smallest node and add its next node to the heap
        while (!minHeap.isEmpty()) {
            // Get the smallest node currently in the heap
            ListNode smallest = minHeap.poll();

            // Append the smallest node to the merged linked list
            current.next = smallest;
            current = current.next;

            // If the extracted node has a next node, push it into the min-heap
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        // Return the head of the merged linked list
        return dummy.next;
    }
    // Helper method to create a linked list from an array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create 3 sorted linked lists:
        // List 1: 1 -> 4 -> 5
        // List 2: 1 -> 3 -> 4
        // List 3: 2 -> 6
        ListNode[] lists = new ListNode[3];
        lists[0] = createList(new int[]{1, 4, 5});
        lists[1] = createList(new int[]{1, 3, 4});
        lists[2] = createList(new int[]{2, 6});

        System.out.println("Input Sorted Linked Lists:");
        for (int i = 0; i < lists.length; i++) {
            System.out.print("List " + (i + 1) + ": ");
            printList(lists[i]);
        }

        // Merge all k sorted lists
        ListNode mergedHead = mergeKLists(lists);

        System.out.println("\nMerged Sorted Linked List:");
        printList(mergedHead);
    }
    
}
