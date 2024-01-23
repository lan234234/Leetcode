package linkedlist;

/*
Given a linked list, check whether it is a palindrome.



clarify:
null?
assume: no circular

 */

public class IsPalindrome_306 {
    public boolean isPalindrome(ListNode head) {
        // corner case:
        if(head == null || head.next == null) {
            return true;
        }
        // general case:
        // step 1: find the middle (if number of nodes is even, find the second node of the middle 2 nodes)
        ListNode middle = findMiddle(head);
        ListNode head2 = middle.next;
        // split the list to two parts
        middle.next = null;
        // step 2: reverse the list in the left
        head2 = reverse(head2);
        // step 3: compare two parts
        return compare(head, head2);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        // base case:
        if (head == null || head.next == null) {
            return head;
        }
        // recursion rule:
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private boolean compare(ListNode one, ListNode two) {
        while (one != null && two != null) {
            if (one.value != two.value) {
                return false;
            } else {
                one = one.next;
                two = two.next;
            }
        }
        return true;
    }

//    time complexity: O(n)
//    space complexity: O(n)


}
