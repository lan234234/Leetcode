package heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap<E extends Comparable<E>> {

    // instance fields:
    Object[] array;
    int size;
    int DEFAULT_CAPACITY = 16;

    // constructors:
    public MinHeap() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public MinHeap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Invalid argument");
        }
        array = new Object[capacity];
    }

    public MinHeap(E[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    // methods:

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }

    private void increaseCapacity() {
        array = Arrays.copyOf(array, (int) (array.length * 1.5));
    }

    public boolean offer(E e) {
        if (isFull()) {
            increaseCapacity();
        }
        array[size] = e;
        percolateUp(size);
        size++;
        return true;
    }

    public E peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        return (E) array[0];
    }

    public E poll() {
        if (isEmpty())	throw new NoSuchElementException("heap is empty");
        E oldE = (E) array[0];
        array[0] = array[--size];
        percolateDown(0);
        return oldE;
    }

    private void percolateDown(int index) {
        while (2 * index + 1 < size) {		// has child
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            int swapIndex = leftChild;
            if (rightChild < size && ((E) array[rightChild]).compareTo((E) array[leftChild]) < 0) {
                swapIndex = rightChild;
            }
            if (((E) array[swapIndex]).compareTo((E) array[index]) < 0) {
                swap(swapIndex, index);
                index = swapIndex;
            } else {
                return;
            }
        }
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (((E) array[parent]).compareTo((E) array[index]) > 0) {
                swap(parent, index);
                index = parent;
            } else {
                return;
            }
        }
    }

    private void heapify() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            percolateDown(i);
        }
    }

    private void swap(int i, int j) {
        E temp = (E) array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
