package dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class JumpGameVIII_2297 {
    public long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int[] nextGreaterOrEqual = new int[n];
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peekFirst()]) {
                stack.offerFirst(i);
            } else {
                int index = stack.pollFirst();
                nextGreaterOrEqual[index] = i;
                i--;
            }
        }

        stack = new ArrayDeque<>();
        int [] nextSmaller = new int[n];
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] >= nums[stack.peekFirst()]) {
                stack.offerFirst(i);
            } else {
                int index = stack.pollFirst();
                nextSmaller[index] = i;
                i--;
            }
        }

        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int index = nextGreaterOrEqual[i];
            if (index != 0) {
                dp[index] = Math.min(dp[index], dp[i] + costs[index]);
            }
            index = nextSmaller[i];
            if (index != 0) {
                dp[index] = Math.min(dp[index], dp[i] + costs[index]);
            }
        }
        return dp[n - 1];
    }
}
