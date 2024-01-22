package linkedlist;

/*
/ Given a linked list and a target value T, partition it such that all nodes less than T
are listed before the nodes larger than or equal to target value T.
The original relative order of the nodes in each of the two partitions should be preserved.
 */

public class PartitionLinkedList_42 {
    public ListNode partitionLinkedList(ListNode head, int target) {
        //corner case: head is null or only 1 node in the linked list
        if (head == null || head.next == null) {
            return head;
        }
        //general case:
        ListNode cur = head;		//traverse the linked list
        ListNode smallDummy = new ListNode(-1);		//as the dummy head of the linked list which only contain the small node
        ListNode largeDummy = new ListNode(-1);		//as the dummy head of the linked list which only contain the large node
        ListNode tailSmall = smallDummy;			//point to the tail of the large list
        ListNode tailLarge = largeDummy;			//point to the tail of the small list
        while (cur != null) {
            if (cur.value < target) {
                tailSmall.next = cur;
                tailSmall = cur;
            } else {
                tailLarge.next = cur;
                tailLarge = cur;
            }
            cur = cur.next;
        }
        tailSmall.next = largeDummy.next;
        tailLarge.next = null;
        return smallDummy.next;
    }
//    time complexity: O(n)
//    space complexity: O(1)

}
