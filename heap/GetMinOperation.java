package heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GetMinOperation {

    // method 1:
    public int getMinOperations(int[] executionTime, int x, int y) {
        // the elements in the maxHeap are the index, and they are sorted based on execution time
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> (executionTime[j] - executionTime[i]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return executionTime[j] - executionTime[i];
            }
        });

        for (int i = 0; i < executionTime.length; i++) {
            maxHeap.offer(i);
        }

        int maxIndex = maxHeap.poll();
        int count = 0;
        while (executionTime[maxIndex] > 0) {
            count++;
            for (int i = 0; i < executionTime.length; i++) {
                if (i == maxIndex) {
                    executionTime[i] -= x;
                } else {
                    executionTime[i] -= y;
                }
            }
            maxHeap.offer(maxIndex);
            maxIndex = maxHeap.poll();
        }
        return count;
    }

    // method 2:
    public int minOperations(List<Integer> executionTime, int x, int y) {
        int left = 0;
        // right represents the max operations it may need
        int right = getMax(executionTime) / y + 1;	// if max is an odd number, is should + 1
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // if it can be completed within mid operations, then we can try smaller operations
            if (canComplete(executionTime, x, y, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    // find the max element in the list
    private int getMax(List<Integer> list) {
        int max = list.get(0);
        for (int n : list) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
    // check if all jobs can be completed within the given number of operations
    private boolean canComplete(List<Integer> list, int x, int y, int operations) {
        int majorOperations = 0;
        int reducedTime = operations * y;	// store the # of operations needed on of major jobs
        for (int num : list) {	// the total reducedTime for non-major job with operations
            // if this job can not be completed as non-major job within given operations
            if (num > reducedTime) {
                int remain = num - reducedTime;	// represent remain time to complete this job
                // majorOperations += (remain + x - y - 1) / (x - y);
                int diff = x - y;
                majorOperations += remain / diff;
                if (remain % diff != 0) {
                    majorOperations++;
                }
            }
            if (majorOperations > operations)	return false;
        }
        return true;
    }
    
}
