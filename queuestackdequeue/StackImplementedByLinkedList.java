package queuestackdequeue;

import linkedlist.ListNode;

public class StackImplementedByLinkedList {
    // member field:
    int size;
    ListNode head;

    // API:
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean push(Integer n) {
        ListNode newHead = new ListNode(n);
        newHead.next = head;
        size++;
        head = newHead;
        return true;
    }
    public Integer pop() {
        if (head == null) {
            return null;
        }
        ListNode result = head;
        head = head.next;
        result.next = null;
        size--;
        return result.value;
    }
    public Integer top() {
        return size == 0 ? null : head.value;
    }

}
