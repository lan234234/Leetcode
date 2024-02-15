package heap;

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

}
