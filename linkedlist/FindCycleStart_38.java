package linkedlist;

/**
 * Check if a given linked list has a cycle.
 * Return the node where the cycle starts. Return null if there is no cycle.
 */
public class FindCycleStart_38 {
    public ListNode findCycleStart(ListNode head) {
        ListNode cycle = hasCycle(head);
        if (cycle == null) {
            return null;
        }
        while (head != cycle) {
            head = head.next;
            cycle = cycle.next;
        }
        return head;
    }
    // if the linked list contains a cycle, return the node in the cycle
    // otherwise, return null
    private ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }


}
