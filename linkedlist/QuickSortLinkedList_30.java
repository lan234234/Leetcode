package linkedlist;

public class QuickSortLinkedList_30 {
    public ListNode quickSortLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return quickSort(head)[0];
    }
    // quick sort the given linked list and return a ListNode[] containing the head and tail
    private ListNode[] quickSort(ListNode head) {
        // base case:
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new ListNode[]{head, head};
        }
        // recursive rule:
        // step 1: set head as pivot
        ListNode cur = head.next;
        head.next = null;
        // step 2: partition
        ListNode smallEqual = new ListNode(-1);
        ListNode smallCur = smallEqual;
        ListNode large = new ListNode(-1);
        ListNode largeCur = large;
        while (cur != null) {
            if (cur.value < head.value) {
                smallCur.next = cur;
                smallCur = cur;
            } else {
                largeCur.next = cur;
                largeCur = cur;
            }
            cur = cur.next;
        }
        smallCur.next = null;
        largeCur.next = null;
        // step  3: sort two part
        ListNode[] newSmall = quickSort(smallEqual.next);
        ListNode[] newLarge = quickSort(large.next);
        // step 4: link
        return link(head, newSmall, newLarge);
    }

    private ListNode[] link(ListNode head, ListNode[] small, ListNode[] large) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        if (small != null) {
            tail.next = small[0];
            tail = small[1];
        }
        tail.next = head;
        tail = head;
        if (large != null) {
            tail.next = large[0];
            tail = large[1];
        }

        return new ListNode[] {dummy.next, tail};
    }

}
