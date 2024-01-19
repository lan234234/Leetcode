package linkedlist;

/*
clarify:
assume:
single no cycle linkedList
if head == null	return null
if k <= 0	return null
if k > length	return null

input: ListNode head, int k
output: ListNode

 */

public class FindKthListNode {
    public class ListNode {
        int val;
        ListNode next;
        //constructor:
        ListNode(int n) {
            val = n;
        }
    }

    public ListNode findKthListNode(ListNode head, int k) {
        //corner case:
        if (head == null || k <= 0) {
            return null;
        }
        //general case:
        while (k > 1 || head != null) {
            k--;
            head = head.next;
        }
        return head;
    }

}
