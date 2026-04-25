class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]: longest subsequence end at i
        int[] dp = new int[n];
        // counts[i]: count longest subsequence end at i
        int[] counts = new int[n];
        int longest = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            counts[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    int curLen = dp[j] + 1;
                    if (curLen > dp[i]) {
                        dp[i] = curLen;
                        counts[i] = counts[j];
                    } else if (curLen == dp[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            if (longest == dp[i]) {
                count += counts[i];
            } else if (longest < dp[i]) {
                longest = dp[i];
                count = counts[i];
            }
        }

        return count;
    }
}