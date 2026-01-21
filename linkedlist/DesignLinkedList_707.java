package linkedlist;

public class DesignLinkedList_707 {
    ListNode head;
    ListNode tail;
    int size;

    public DesignLinkedList_707() {
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        size = 0;
    }

    public int get(int index) {
        ListNode node = find(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)  return;
        ListNode pre = index == 0 ? head : find(index - 1);
        ListNode newNode = new ListNode(val, pre.next);
        pre.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode pre = index == 0 ? head : find(index - 1);
        pre.next = pre.next.next;
        size--;
    }

    private ListNode find(int index) {
        if (index < 0 || index >= size)  return null;
        int count = 0;
        ListNode cur = head;
        while (count <= index) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
            this.val = -1;
            next = null;
        }

        public ListNode(int val) {
            this.val = val;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
