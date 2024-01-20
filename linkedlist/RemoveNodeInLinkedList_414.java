package linkedlist;

/*
Remove all elements from a linked list of integers that have value val.

assume: single linkedList without cycle

 */

public class RemoveNodeInLinkedList_414 {
    public class ListNode {
        int value;
        ListNode next;
        // constructor
        ListNode(int n) {
            value = n;
        }
    }
    public ListNode removeNodeInLinkedList(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;
        while (head != null) {
            if (head.value == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
//    time complexity: O(n)
//    space complexity: O(1)

}
