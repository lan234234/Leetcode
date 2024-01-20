package linkedlist;

/*
Insert a value in a sorted linked list.

clarify:
if head == null		return new ListNode(target)

assume:
if duplicate	insert in any valid position

input: ListNode head, int target
output: ListNode newHead

 */

public class InsertInSortedLinkedList_39 {
    public class ListNode {
        int val;
        ListNode next;
        //constructor:
        ListNode(int n) {
            val = n;
        }
    }
    public ListNode insertInSortedLinkedList(ListNode head, int target) {
        ListNode newNode = new ListNode(target);
        //general case:
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val < target) {
                cur = cur.next;
            } else {
                //case 1: insert Node in somewhere after dummy and before end
                newNode.next = cur.next;
                cur.next = newNode;
                return dummy.next;
            }
        }
        //case 2: head is null or insert Node after the end
        cur.next = newNode;
        return dummy.next;
    }
//    time complexity: O(n)
//    space complexity: O(1)

}
