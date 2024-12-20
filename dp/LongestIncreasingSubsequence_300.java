package dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence_300 {
    /**
     * method 1: dp
     */

    public int solution1(int[] nums) {
        int n = nums.length;
        // corner case:
        if (n == 1)   return 1;
        // general case:
        int max = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    /**
     * method 2: binary search
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > sub.get(sub.size() - 1)) {
                sub.add(nums[i]);
            } else {
                sub.set(firstLargerOrEqual(sub, nums[i]), nums[i]);
            }
        }
        return sub.size();
    }

    private int firstLargerOrEqual(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
