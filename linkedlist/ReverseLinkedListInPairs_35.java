package linkedlist;

public class ReverseLinkedListInPairs_35 {
/*
/   Reverse pairs of elements in a linked list.


    assume:
    single linked list without circular
    head == null		return head
    odd number of ListNode: no need to reverse the last ListNode

    input: ListNode head
    output: ListNode newHead
 */


    /*
    / method 1: recursion
     */
    public ListNode reverseLinkedListInPair1(ListNode head) {
        // base case:
        if (head == null || head.next == null) {
            return head;
        }
        // general case:
        ListNode newHead = head.next;
        ListNode nextHead = reverseLinkedListInPair1(head.next.next);
        newHead.next = head;
        head.next = nextHead;
        return newHead;
    }
//    time complexity: O(n)
//    space complexity: O(n)


    /*
     method 2: iterative
     */
    public ListNode reverseListNodeInPair2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            pre.next = node1.next;
            node1.next = node1.next.next;
            pre.next.next = node1;
            pre = node1;
        }
        return dummy.next;
    }
//    time complexity: O(n)
//    space complexity: O(1)

}
