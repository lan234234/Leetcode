/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)  return head;

        int count = getCount(head);
        k %= count;
        if (k == 0) return head;

        ListNode cur = head;
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        ListNode pre = head;
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        ListNode newHead = pre.next;
        pre.next = null;
        cur.next = head;
        return newHead;
    }

    private int getCount(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}