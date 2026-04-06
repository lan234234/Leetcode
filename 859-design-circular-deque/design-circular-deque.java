class MyCircularDeque {
    int[] arr;
	int first;
	int last;
	int size;

    public MyCircularDeque(int k) {
        arr = new int[k];
		first = 0;
		last = k -1;
		size = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull())	return false;
		first = (first - 1 + arr.length) % arr.length;
		arr[first] = value;
		size++;
		return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull())	return false;
		last = (last + 1) % arr.length;
		arr[last] = value;
		size++;
		return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty())	return false;
		first = (first + 1) % arr.length;
		size--;
		return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty())	return false;
		last = (last - 1 + arr.length) % arr.length;
		size--;
		return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : arr[first];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : arr[last];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == arr.length;
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