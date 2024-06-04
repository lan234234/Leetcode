package linkedlist;

public class RotateListByKPlaces_166 {
    public ListNode rotateListByKPlaces(ListNode head, int k) {
        // assume no cycle
        // assume single linked list
        // assume the length of the list is in integer range
        // corner case:
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        // general case:
        // step 1: get nth node
        ListNode node = getNth(head, k);
        if (node.next == null) {
            return head;
        }
        // step 2: get the nth and (n + 1)th node from end
        ListNode pre = null;	// the node n +1th node from end
        ListNode cur = head;	// the nth node from end
        while (node.next != null) {
            pre = cur;
            node = node.next;	// will finally point to the last node
            cur = cur.next;
        }
        // step 3: rotate list
        pre.next = null;
        node.next = head;
        return cur;
    }

    private ListNode getNth(ListNode head, int n) {
        // base case:
        if (n == 1) {
            return head;
        }
        // step 1: find the nth node from head
        int count = 1;
        ListNode cur = head;
        while (count != n && cur.next != null ) {
            cur = cur.next;
            count++;
        }
        // case 1:nth node is found
        if (count == n) {
            return cur;
        }
        n = n % count;
        n = n == 0 ? count : n;
        // case 2: n is larger than list's length
        return getNth(head, n);
    }

}
