package linkedlist;

public class MergeSortLinkedList_29 {
    public ListNode mergeSortLinkedList(ListNode head) {
        // base case:
        if (head == null || head.next == null) {
            return head;
        }
        // general case:
        //step 1: split the list from the middle
        ListNode middle = middleNode(head);
        ListNode rightHead = middle.next;
        middle.next = null;	//break the link between 2 parts
        // step 2: sort these two parts
        ListNode leftHead = mergeSortLinkedList(head);
        rightHead = mergeSortLinkedList(rightHead);
        // step 3: merge these two parts
        return mergeLinkedList(leftHead, rightHead);
    }

    // odd numbers of nodes --> return the middle
    // even			    --> return the first node in the two middle nodes
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeLinkedList(ListNode one, ListNode two) {
        // corner case:
        if (one == null || two == null) {
            return one == null ? two : one;
        }
        // general case:
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (one != null && two != null) {
            if (one.value <= two.value) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        cur.next = one == null ? two : one;
        return dummy.next;
    }
/*
    time complexity: split + merge
        split: O(nlogn)
        merge: O(nlogn)
    space complexity: heap + stack
        heap: O(1)
        stack: O(logn)
 */

}
