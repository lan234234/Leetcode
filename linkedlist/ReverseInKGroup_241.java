package linkedlist;

public class ReverseInKGroup_241 {
    public ListNode reverseInKGroup(ListNode head, int k) {
        // corner case: k is invalid or k is 1
        if (k <= 1) {
            return head;
        }
        // base case: the number of nodes in the list is less than k
        ListNode kthNode = getKthNode(head, k);
        if (kthNode == null) {
            return head;
        }
        // recursive rule:
        // sub-problem: reverse the part after the kth node
        ListNode next = reverseInKGroup(kthNode.next, k);
        kthNode.next = null;	// unlink the link between the kth and th (k + 1)th node
        // reverse the nodes from the first one to the kth one
        reverse(head);
        // link the two part again
        head.next = next;
        return kthNode;
    }

    /**
     * get the kth node in the list
     * if the number of nodes in the list is smaller than k, return null
     */
    private ListNode getKthNode(ListNode head, int k) {
        // corner case:
        if (head == null) {
            return head;
        }
        // general case:
        while (head.next != null && k > 1) {
            head = head.next;
            k--;
        }
        return k == 1 ? head : null;
    }

    /**
     * reverse the linked list
     */
    private void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

}
