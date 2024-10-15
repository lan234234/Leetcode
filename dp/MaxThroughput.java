package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxThroughput {
    public int getMaximumThroughput(int[] throughput, int[] scaling_cost, int budget) {
        // corner case: invalid input
        if (throughput == null || throughput.length == 0 || scaling_cost == null || scaling_cost.length == 0 || throughput.length != scaling_cost.length || budget <= 0)	return 0;
        // general case:
        // minHeap: store the index of the throughput and sorted according to the corresponding throughput value
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((index1, index2) -> throughput[index1] - throughput[index2]);
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return throughput[o1] - throughput[o2];
//            }
//        });
        for (int i = 0; i < throughput.length; i++) {
            minHeap.offer(i);
        }
        int[] original = Arrays.copyOf(throughput, throughput.length);	// store the original throughput
        int minIndex = minHeap.poll();
        while (scaling_cost[minIndex] <= budget) {
            throughput[minIndex] += original[minIndex];
            budget -= scaling_cost[minIndex];
            minHeap.offer(minIndex);
            minIndex = minHeap.poll();
        }
        return throughput[minIndex];
    }

}
