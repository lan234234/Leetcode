package queuestackdequeue;

public class CircularQueue {
    // member variable
    int[] array;
    int firstIndex;	//current position of first element
    int lastIndex;	//current position of last element
    int size;
    // API
    public CircularQueue(int capability) {
        array = new int[capability];
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean enQueue(int n) {
        if (this.isFull()) {
            return false;
        }
        if (size != 0) {
            lastIndex = lastIndex == array.length - 1 ? 0 : ++lastIndex;
        }
        array[lastIndex] = n;
        size++;
        return true;

    }
    public Integer front() {
        return size == 0 ? null : array[firstIndex];
    }
    public Integer rear() {
        return size == 0 ? null : array[lastIndex];
    }
    public Integer deQueue() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            size--;
            return array[firstIndex];
        }
        int result = array[firstIndex];
        firstIndex = firstIndex == array.length - 1 ? 0 : ++firstIndex;
        size--;
        return result;
    }
    public boolean isFull() {
        return size == array.length;
    }


}
