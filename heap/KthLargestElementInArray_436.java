package heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray_436 {
    public int kthLargestInUnsortedArray(int[] array, int k) {
        // corner case:
        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            return -1;
        }
        // general case:
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;	// traverse array
        // step 1: offer k elements to a maxHeap
        while (i < k) {
            minHeap.offer(array[i++]);
        }
        // step 2: offer the rest n - k elements to the maxHeap
        while (i < array.length) {
            if (minHeap.peek() < array[i]) {
                minHeap.poll();
                minHeap.offer(array[i]);
            }
            i++;
        }
        return minHeap.peek();
    }

}
