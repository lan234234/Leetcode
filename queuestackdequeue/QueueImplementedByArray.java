package queuestackdequeue;

public class QueueImplementedByArray {
    // member variable
    int[] array;
    int firstIndex;	//current position of first element
    int lastIndex;	//current position of last element
    int size;
    // API
    public QueueImplementedByArray(int capability) {
        array = new int[capability];
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean offer(Integer n) {
        if (lastIndex == array.length - 1 && size != 0) {
            return false;
        }
        if (size == 0) {
            array[lastIndex] = n;
        } else {
            array[++lastIndex] = n;
        }
        size++;
        return true;
    }
    public Integer peek() {
        return size == 0 ? null : array[firstIndex];
    }
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            size--;
            return array[firstIndex];
        }
        int result = array[firstIndex++];
        size--;
        return result;

    }


}
