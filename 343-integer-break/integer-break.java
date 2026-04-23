class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n + 1];
        dp[1] = 1;
        return maxBreak(n);
    }

    private int maxBreak(int n) {
        if (dp[n] != 0) return dp[n];

        for (int cut = 1; cut <= n / 2; cut++) {
            int first = Math.max(maxBreak(cut), cut);
            int second = Math.max(maxBreak(n - cut), n - cut);
            dp[n] = Math.max(first * second, dp[n]);
        }
        return dp[n]; 
    }
}