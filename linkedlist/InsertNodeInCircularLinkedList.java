package linkedlist;

/*
insert a node in a circular linked list



clarify:
sorted
before the insertion, is head.val the smallest ?
head == null	return newNode with circular
no duplicate

input: ListNode head, int target

 */

public class InsertNodeInCircularLinkedList {
    public ListNode insertNodeInCircularLinkedList(ListNode head, int target) {
        ListNode newNode = new ListNode(target);
        // corner case:
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (head.value < target) {
            // no node with value >= target
            // case 1: there is only 1 node in the circular (this node must have the largest value)
            // case 2: cur.value is the largest, next.value is the smallest and cur is not dummy
            if (cur == head || (cur.value > head.value && cur != dummy)) {
                cur.next = newNode;
                newNode.next = head;
                return dummy.next;
            }
            cur = head;
            head = head.next;
        }
        // case 3: next with value > target, insert newNode before next
        cur.next = newNode;
        newNode.next = head;
        return dummy.next;
    }

}
