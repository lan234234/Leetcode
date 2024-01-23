package linkedlist;

/*
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.



assume: on circular

 */

public class AddTwoNumbersII_L445 {
    public ListNode add2Numbers(ListNode one, ListNode two) {
        // base case:
        if (one == null || two == null) {
            return one == null ? two : one;
        }
        // general case:
        // step 1: reverse one and two
        one = reverseLinkedList(one);
        two = reverseLinkedList(two);
        // step 2: calculate the sum and create the new list
        ListNode cur1 = one;
        ListNode cur2 = two;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int sum = 0;
        while (cur1 != null && cur2 != null) {
            sum += cur1.value + cur2.value;
            cur.next = sum < 10 ? new ListNode(sum) : new ListNode(sum - 10);
            sum = sum < 10 ? 0 : 1;
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        ListNode newCur = cur1 == null ? cur2 : cur1;
        // continue to calculate the sum when sum != 0
        while (newCur != null && sum != 0) {
            sum += newCur.value;
            cur.next = sum < 10 ? new ListNode(sum) : new ListNode(sum - 10);
            sum = sum < 10 ? 0 : 1;
            cur = cur.next;
            newCur = newCur.next;
        }
        if (sum == 0) {
            // directly link the rest list
            cur.next = newCur;
        } else {
            // create a new ListNode with value 1
            cur.next = new ListNode(1);
        }
        ListNode head = dummy.next;
        dummy.next = null;
        return reverseLinkedList(head);
    }

    private ListNode reverseLinkedList(ListNode head) {
        // corner case:
        if (head == null || head.next == null) {
            return head;
        }
        // general case:
        // cur: point to the current node which need to be reversed
        ListNode cur = head.next;
        // head: points to the head of the reversed list
        head.next = null; 		// break the link between head and the next node
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }
//    time complexity: O(m + n)
//    space complexity: O(1)


}
