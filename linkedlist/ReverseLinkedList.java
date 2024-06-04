package linkedlist;

/*
Reverse a singly-linked list.


clarify:
assume: no circle

input: ListNode head
output: ListNode newHead

 */

public class ReverseLinkedList {
    /*
    / method 1: iterative
     */
    public ListNode reverseLinkedList_34(ListNode head) {
        // corner case:
        if (head == null || head.next == null) {
            return head;
        }
        // general case:
        ListNode pre = null;		// head of the reversed list
        ListNode next;			// the next node of the unreversed list's head
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }
//    time complexity: O(n)
//    space complexity: O(1)

    /*
    / method 2: recursive
     */
    public ListNode reverseLinkedList_653(ListNode head) {
        //base case:
        if (head == null || head.next == null) {
            return head;
        }
        //general case:
        ListNode newHead = reverseLinkedList_653(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
//    time complexity: O(n)
//    space complexity: O(n)


}
