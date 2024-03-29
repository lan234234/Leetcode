package linkedlist;

/*
clarify:
if head == null		return null
if length is odd		return middle
if 	      even	return first nodes of middle ?
assume: single linkedList without cycle
input: ListNode head
output: ListNode

 */

public class MiddleOfLinkedList_36 {
    public ListNode middleOfLinkedList(ListNode head) {
        //corner case:
        if (head == null) {
            return null;
        }
        //general case:
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
//    time complexity: O(n)
//    space complexity: O(1)

}
