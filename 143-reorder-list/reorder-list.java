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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)  return;

        ListNode mid = findMid(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        merge(head, right);
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)  return head;

        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private ListNode merge(ListNode ls1, ListNode ls2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (ls1 != null && ls2 != null) {
            cur.next = ls1;
            ls1 = ls1.next;
            cur.next.next = ls2;
            cur = ls2;
            ls2 = ls2.next;
        }
        cur.next = ls1 != null ? ls1 : ls2;
        return dummy.next;
    }
}