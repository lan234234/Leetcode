package linkedlist;


public class InsertNodeInCircularLinkedList {
    public ListNode insertNodeInCircularLinkedList(ListNode head, int val) {
        // assume the given linked list is guaranteed to have a cycle
        // assume all nodes in list are sorted in ascending order based on their values
        ListNode newNode = new ListNode(val);
        // corner case:
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        // general case:
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur.value < val && (pre == dummy || cur.value >= pre.value) && cur != pre) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = newNode;
        newNode.next = cur;
        return dummy.next;

    }

}
