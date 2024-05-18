package linkedlist;

public class RotateListByKPlaces_166 {
    public ListNode rotateListByKPlaces(ListNode head, int k) {
        // assume k >= 0
        // corner case:
        if (k == 0 || head == null) {
            return head;
        }
        // general case:
        // step 1: find kth element
        ListNode fast = findKth(head, k);
        if (fast.next == head) {
            return rotateListByKPlaces(head, k % fast.value);
        }
        // step 2: find kth from the end
        ListNode pre = null;
        ListNode cur = head;
        while (fast.next != null) {
            pre = cur;
            cur = cur.next;
            fast = fast.next;
        }
        // step 3: rotate
        if (pre == null) {		// can also use dummy
            return head;
        }
        pre.next = null;
        fast.next = head;
        return cur;
    }
    // find kth node, return new ListNode(size) if k > size
    private ListNode findKth(ListNode head, int k) {
        ListNode cur = head;
        int count = 1;
        while (cur != null && k != count) {
            cur = cur.next;
            count++;
        }
        if (cur != null) {
            return cur;
        }
        ListNode node = new ListNode(count - 1);
        node.next = head;
        return node;
    }

}
