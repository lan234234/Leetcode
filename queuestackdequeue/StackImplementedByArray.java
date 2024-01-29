package queuestackdequeue;

public class StackImplementedByArray {
    // member field:
    int[] array;
    int topIndex;		// the index of the top element

    // API
    // constructor:
    public StackImplementedByArray(int capability) {
        array = new int[capability];
        topIndex = -1;
    }
    public int size() {
        return topIndex + 1;
    }
    public boolean isEmpty() {
        return topIndex == -1;
    }
    public boolean push(Integer n) {
        // should discuss with interviewer
        // if (topIndex == array.length - 1) {
        // 	int[] newArray =  new int[array.length * 1.5];
        // 	copy(array, newArray);
        // 	array = newArray;
        // }
        if (topIndex == array.length - 1) {
            return false;
        }
        array[++topIndex] = n;
        return true;
    }
    public Integer pop() {
        return this.isEmpty() ? null : array[topIndex--];
    }
    public Integer top() {
        return this.isEmpty() ? null : array[topIndex];
    }
    public void copy(int[] array, int[] newArray) {
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
    }

}
