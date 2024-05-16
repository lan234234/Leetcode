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
        int remain = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (one != null || two != null) {
            int sum = remain;
            if (one != null) {
                sum += one.value;
                one = one.next;
            }
            if (two != null) {
                sum += two.value;
                two = two.next;
            }
            cur.next = new ListNode(sum % 10);
            remain = sum / 10;
            cur = cur.next;
        }
        if (remain != 0) {
            cur.next = new ListNode(remain);
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
