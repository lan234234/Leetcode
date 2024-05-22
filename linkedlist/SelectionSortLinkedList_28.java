package linkedlist;

public class SelectionSortLinkedList_28 {
    public ListNode selectionSort(ListNode head) {
        // assume it is a single linked list without cycle
        // corner case:
        if (head == null || head.next == null) {
            return head;
        }
// general case:
// recursive rule:
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode smallest = head;
        ListNode sPre = dummy;
        ListNode pre = head;
        ListNode cur = head.next;
        // step 1: find the node with smallest value
        while (cur != null) {
            if (cur.value < smallest.value) {
                smallest = cur;
                sPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        // step 2: de-link
        sPre.next = smallest.next;
        smallest.next = selectionSort(dummy.next);
        return smallest;
    }

}
