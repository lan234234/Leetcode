package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestInUnsortedArray_25 {
    /**
     * method 2: minHeap
     */
    public int[] kSmallestInUnsortedArray(int[] array, int k) {
        // corner case:
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }
        // general case:
        int length = k > array.length ? array.length : k;
        int[] result = new int[length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // step 1: offer all elements in a minHeap
        for (int i = 0; i < array.length; i++) {
            minHeap.offer(array[i]);
        }
        // step 2: poll k elements from the heap
        for (int i = 0; i < length; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
    /**
     * method 3: maxHeap
     */
    public int[] kSmallestInUnsortedArray3(int[] array, int k) {
        // corner case:
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }
        // general case:
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int length = k > array.length ? array.length : k;
        int[] result = new int[length];
        int i = 0;	// traverse array
        // step 1: offer k elements to a maxHeap
        while (i < length) {
            maxHeap.offer(array[i++]);
        }
        // step 2: offer the rest n - k elements to the maxHeap
        while (i < array.length) {
            if (maxHeap.peek() > array[i]) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
            i++;
        }
        // step 3: store the k elements in maxHeap to the result
        for (int j = length - 1; j >= 0; j--) {
            result[j] = maxHeap.poll();
        }
        return result;
    }
    /**
     * method 4: quick sort
     */
    public int[] kSmallestInUnsortedArray4(int[] array, int k) {
        // corner case:
        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            return new int[0];
        }
        // general case:
        partition(array, k, 0, array.length - 1);
        int[] result = new int[k];
        copy(array, result);
        Arrays.sort(result);
        return result;
    }
    private void partition(int[] array, int k, int leftIndex, int rightIndex) {
        // recursion rule:
        // step 1: choose a pivot
        // Math.random() --> [0, 1)
        // [leftIndex, rightIndex + 1) = leftIndex + [0, rightIndex - leftIndex + 1)
        int pivotIndex = (int) (Math.random() * (rightIndex - leftIndex + 1)) + leftIndex;
        // step 2: partition
        swap(array, pivotIndex, rightIndex);
        int i = leftIndex;
        int j = rightIndex - 1;
        while (i <= j) {
            if (array[i] <= array[rightIndex]) {
                i++;
            } else if (array[j] > array[rightIndex]) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        swap(array, rightIndex, i);
        // step 3:
        int number = i - leftIndex + 1;
        if (number > k + 1) {
            partition(array, k, leftIndex, i);
        } else if (number < k) {
            partition(array, k - number, i + 1, rightIndex);
        } else {
            return;
        }
    }
    private void copy(int[] array, int[] result) {
        for(int i  = 0; i < result.length; i++) {
            result[i] = array[i];
        }
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
