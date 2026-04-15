class Solution {
    int[][] dp;
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minRemove(s, 0, n - 1) <= k;
    }

    private int minRemove(String s, int start, int end) {
        if (dp[start][end] != -1) return dp[start][end];

        if (end == start) {
            dp[start][end] = 0;
        } else if (end == start + 1) {
            dp[start][end] = s.charAt(start) == s.charAt(end) ? 0 : 1;
        } else if (s.charAt(start) == s.charAt(end)) {
            dp[start][end] = minRemove(s, start + 1, end - 1);
        } else {
            dp[start][end] = 1 + Math.min(minRemove(s, start + 1, end), minRemove(s, start, end - 1));
        }
        return dp[start][end];
    }
}