class MyCircularDeque {
    Node head;
	Node tail;
	int size;
	int capacity;

    public MyCircularDeque(int k) {
        head = new Node(-1);
		tail = new Node(-1);
		head.next = tail;
		tail.pre = head;
		this.capacity = k;
    }
    
    public boolean insertFront(int value) {
        if (isFull())	return false;
		Node node = new Node(value);
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
		size++;
		return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull())	return false;
		Node node = new Node(value);
		node.pre = tail.pre;
		node.next = tail;
		tail.pre.next = node;
		tail.pre = node;
		size++;
		return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty())	return false;
		size--;
		Node node = head.next;
		head.next = node.next;
		node.next.pre = head;
		return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty())	return false;
		size--;
		Node node = tail.pre;
		node.pre.next = tail;
		tail.pre = node.pre;
		return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : head.next.val;
    }
    
    public int getRear() {
        return isEmpty() ? -1 : tail.pre.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }

    class Node {
        int val;
        Node next;
        Node pre;
        
        public Node(int val) {
            this.val = val;
        }
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */