package linkedlist;

/*
/ Check if a given linked list has a cycle. Return true if it does, otherwise return false.



assume: single linked list

 */

public class CheckCycleInLinkedList_37 {
    public class ListNode {
        int val;
        ListNode next;
        //constructor
        ListNode(int n) {
            val = n;
        }
    }
    public boolean checkCycleInLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    //    time complexity: O(n)
    //    space complexity: O(1)
}
