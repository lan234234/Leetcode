package linkedlist;

/*
Given a linked list, count the number of nodes in it.

clarify:
implement ListNode class?
valid no cycle single linkedList
if head == null		return 0

input: ListNode head
output: int
 */

public class CountListNode_555 {
    public int countListNode(ListNode head) {
        int count = 0;
        while( head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
//    time complexity: O(n)
//    space complexity: O(1)

}
