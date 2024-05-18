package linkedlist;

public class RemoveFromEnd_243 {
    public ListNode removeFromEnd(ListNode head, int n) {
        // corner case:
        if (head == null || n <= 0) {
            return head;
        }
        // general case:
        // step 1: find nth node
        ListNode fast = findNthNode(head, n);
        if (fast == null) {
            return head;
        }
        // step 2: find nth from end
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (fast.next != null) {
            pre = cur;
            cur = cur.next;
            fast = fast.next;
        }
        // step 3: remove
        pre.next = cur.next;
        return dummy.next;
    }
    // find the Nth node from head
    private ListNode findNthNode(ListNode head, int n) {
        while (head != null && n != 1) {
            head = head.next;
            n--;
        }
        return head;
    }

}
