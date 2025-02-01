package dp;

import java.util.PriorityQueue;

public class JumpGameVI_1696 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        maxHeap.offer(new int[]{0, nums[0]});
        int score = nums[0];
        for (int i = 1; i < n; i++) {
            while (i - maxHeap.peek()[0] > k) {
                maxHeap.poll();
            }
            score = nums[i] + maxHeap.peek()[1];
            maxHeap.offer(new int[]{i, score});
        }
        return score;
    }
}
