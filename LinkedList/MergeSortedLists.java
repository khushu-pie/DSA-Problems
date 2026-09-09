public class MergeSortedLists {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Spliced together two sorted linked lists into one sorted list.
     * @param list1 Head of the first sorted list
     * @param list2 Head of the second sorted list
     * @return Head of the merged sorted linked list
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy head node to simplify edge cases
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // Traverse both lists and attach the smaller value node to tail
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Attach any remaining nodes from list1 or list2
        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }

        // The merged list starts at dummy.next
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // List 1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // List 2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.print("List 1: ");
        printList(list1);

        System.out.print("List 2: ");
        printList(list2);

        ListNode mergedHead = mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        printList(mergedHead);
    }
}