package linkedlist;

public class CreateLinkedList_554 {
    public class ListNode {
        int val;
        ListNode next;
        //constructor
        ListNode(int n) {
            val = n;
        }
    }

    public ListNode createLinkedList(int n) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return head;
    }

//    time complexity: O(n)
//    space complexity: O(1)

}
