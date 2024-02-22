package bfs;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthSmallestMultiplication_193 {
    public long kthSmallest(int k) {
        // assume k > 0
        // assume the result is in the range of long
        // in visited:
        // key is the result of multiplication
        // no need to use map, because the multiplication is unique for each combination
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long initial = 3 * 5 * 7L;
        visited.add(initial);
        minHeap.offer(initial);
        while (k > 1) {
            Long cur = minHeap.poll();
            k--;
            // generate neighbors and update visited and minHeap
            update(cur, visited, minHeap);
        }
        return minHeap.poll();
    }
    private void update(Long cur, Set<Long> visited, PriorityQueue<Long> minHeap) {
        int[] factors = new int[]{3, 5, 7};
        for (int factor : factors) {
            Long temp = factor * cur;
            if (!visited.contains(temp)) {
                visited.add(temp);
                minHeap.offer(temp);
            }
        }
    }

}
