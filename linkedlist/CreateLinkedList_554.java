package linkedlist;

/*
Generate a linked list of length n, where the nodes contains numbers from 0 to n-1 in order.

clarify:
Can I directly use the ListNode class or I have to implement it?
assume:
n > 0

input: int n
output: ListNode (head of the linkedList)

 */

public class CreateLinkedList_554 {

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
