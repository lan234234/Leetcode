package ood;

import java.util.Arrays;

public class MyArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int RESIZE_FACTOR = 2;

    private int[] array;
    private int size;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("capacity < 0");
        array = new int[Math.max(capacity, DEFAULT_CAPACITY)];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int get(int index) {
        validIndex(index);
        return array[index];
    }

    public int set(int index, int val) {
        validIndex(index);
        int oldVal = array[index];
        array[index] = val;
        return oldVal;
    }

    public boolean add(int val) {
        return add(size, val);
    }

    public boolean add(int index, int val) {
        validIndexForAdd(index);

        if (size == array.length) {
            resize();
        }

        // shift elements to the right
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = val;
        size++;
        return true;
    }

    public int remove(int index) {
        validIndex(index);
        int removed = array[index];

        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removed;
    }

    private void resize() {
        int newCap = array.length * RESIZE_FACTOR;
        if (newCap < 0) throw new OutOfMemoryError("too large");
        array = Arrays.copyOf(array, array.length * RESIZE_FACTOR);
    }

    private void validIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void validIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }


}
