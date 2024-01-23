package linkedlist;

/*
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … ->
 Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null



assume:
    no circular

 */

public class ReOrderLinkedList_41 {
    public ListNode reOrderLinkedList(ListNode head) {
        // corner case:
        if (head == null || head.next == null) {
            return head;
        }
// general case:
// step 1: find the middle and split
        ListNode middle = findMiddle(head);
        ListNode head2 = middle.next;
        middle.next = null;
// step 2: reverse the list in the right
        head2 = reverse(head2);
// step 3: merge two lists
        return merge(head, head2);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        // corner case:
        if (head == null || head.next == null) {
            return head;
        }
// general case:
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (two != null) {
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            cur = two;
            two = two.next;
        }
        cur.next = one;
        return dummy.next;
    }
//    time complexity: O(n)
//    space complexity: O(1)

}
