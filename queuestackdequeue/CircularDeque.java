package queuestackdequeue;

public class CircularDeque {
    // member field:
    int[] array;
    int firstIndex;		// the index of the first element
    int lastIndex;		// the index of the last element
    int size;
    // API:
    public CircularDeque(int n) {
        array = new int[n];
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public Integer getFront() {
        return this.isEmpty() ? null : array[firstIndex];
    }
    public Integer getRear() {
        return this.isEmpty() ? null : array[lastIndex];
    }
    public boolean insertFront(int n) {
        if (this.isFull()) {
            return false;
        }
        if (!this.isEmpty()) {
            firstIndex = firstIndex == 0 ? array.length - 1 : --firstIndex;
        }
        array[firstIndex] = n;
        size++;
        return true;
    }
    public boolean insertLast(int n) {
        if (this.isFull()) {
            return false;
        }
        if (!this.isEmpty()) {
            lastIndex = lastIndex == array.length - 1 ? 0 : ++lastIndex;
        }
        array[lastIndex] = n;
        size++;
        return true;
    }
    public Integer deleteFront() {
        if (this.isEmpty()) {
            return null;
        }
        int result = array[firstIndex];
        if (size != 1) {
            firstIndex = firstIndex == array.length - 1 ? 0 : ++firstIndex;
        }
        size--;
        return result;
    }
    public Integer deleteLast() {
        if (this.isEmpty()) {
            return null;
        }
        int result = array[lastIndex];
        if (size != 1) {
            lastIndex = lastIndex == 0 ? array.length - 1 : --lastIndex;
        }
        size--;
        return result;
    }
    public boolean isFull() {
        return size == array.length;
    }
}

