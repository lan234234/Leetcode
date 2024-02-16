package heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap{
    int[] array;
    int size;

    public MinHeap(int capability) {
        if (capability <= 0) {
            throw new IllegalArgumentException("capability can not be <= 0");
        }
            array = new int[capability];
    }

    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        return array[0];
    }

    public void offer(int n) {
        if (isFull()) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
        array[size] = n;
        percolateUp(size);
        size++;
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        int result = array[0];
        array[0] = array[--size];
        percolateDown(0);
        return result;
    }

    public int update(int index, int ele) {
        // corner case:
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("invalid index range");
        }
// general case:
        int oldEle = array[index];
        array[index] = ele;
        if (oldEle > ele) {
            percolateUp(index);
        } else if (oldEle < ele) {
            percolateDown(index);
        }
        return oldEle;
    }

    public void percolateUp(int index) {
        while (index != 0) {
            int parentIndex = (index - 1) / 2;
            if (array[parentIndex] > array[index]) {
                swap(array, parentIndex, index);
                index = parentIndex;
            } else {
                return;
            }
        }
    }

    public void percolateDown(int index) {
        while (2 * index + 1 < size) {		// has child
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            int swapIndex = leftChild;
            if (rightChild < size && array[rightChild] < array[leftChild]) {
                swapIndex = rightChild;
            }
            if (array[swapIndex] < array[index]) {
                swap(array, swapIndex, index);
                index = swapIndex;
            } else {
                return;
            }
        }
    }

    public void heapify() {		// no arguments
        for (int index = (size - 2) / 2; index >= 0; index--) {
            percolateDown(index);
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

