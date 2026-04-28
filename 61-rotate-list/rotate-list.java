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

        // 1. get size
        int size = getSize(head);
        k %= size;
        if (k == 0) return head;

        // 2. find kth node (start at 0)
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            node = node.next;
        }

        // 3. find break
        ListNode cur = head;
        while (node.next != null) {
            node = node.next;
            cur = cur.next;
        }

        // 4. reorder
        node.next = head;
        head = cur.next;
        cur.next = null;

        return head;
    }

    private int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}