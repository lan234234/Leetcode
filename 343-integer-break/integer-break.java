class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int cut = 1; cut <= i / 2; cut++) {
                dp[i] = Math.max(cut * Math.max(i - cut, dp[i - cut]), dp[i]);
            }
        }
        return dp[n];
    }
}