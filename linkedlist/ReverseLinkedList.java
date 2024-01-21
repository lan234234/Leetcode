package linkedlist;

/*
Reverse a singly-linked list.


clarify:
assume: no circle

input: ListNode head
output: ListNode newHead

 */

public class ReverseLinkedList {
    public class ListNode {
        int value;
        ListNode next;
        //constructor:
        ListNode(int n) {
            value = n;
        }
    }
    /*
    / method 1: iterative
     */
    public ListNode reverseLinkedList_34(ListNode head) {
        //corner case:
        if (head == null || head.next == null) {
            return head;
        }
        //general case:
        ListNode pre = head;	//the head of the linkedList which is already reversed
        ListNode cur = pre.next;		//the head of the remaining linkedList
        ListNode next = cur.next;
        //break the link between head and cur
        head.next = null;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
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
