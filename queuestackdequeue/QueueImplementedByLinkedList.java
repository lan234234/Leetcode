package queuestackdequeue;

import linkedlist.ListNode;

public class QueueImplementedByLinkedList {
    // field:
    ListNode head;	// point to the first element
    ListNode tail;		// point to the last element
    int size;		// store the size of the linked list

    // API
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean offer(Integer n) {
        ListNode newTail = new ListNode(n);
        if (this.isEmpty()) {
            head = newTail;
            tail = newTail;
        } else {
            tail.next = newTail;
            tail = newTail;
        }
        size++;
        return true;
    }
    public Integer peek() {
        return this.isEmpty() ?  null : head.value;
    }
    public Integer poll() {
        if (this.isEmpty()) {
            return null;
        }
        ListNode result = head;
        head = head.next;
        result.next = null;
        size--;
        return result.value;
    }

}
