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
            dp[n] = Math.max(cut * Math.max(n - cut, maxBreak(n - cut)), dp[n]);
        }
        return dp[n]; 
    }
}