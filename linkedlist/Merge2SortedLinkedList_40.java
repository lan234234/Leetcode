package linkedlist;

/*
Merge two sorted lists into one large sorted list.



clarify:
assume: single linkedlist without cycle

input: ListNode one, ListNode two
output: ListNode

 */

public class Merge2SortedLinkedList_40 {

    public ListNode merge2SortedLinkedList(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (one != null && two != null) {
            if (one.value <= two.value) {
                pre.next = one;
                one = one.next;
            } else {
                pre.next = two;
                two = two.next;
            }
            pre = pre.next;
        }
        pre.next = one == null ? two : one;
        return dummy.next;
    }
//    time complexity: O(m + n)
//    space complexity: O(1)

}
