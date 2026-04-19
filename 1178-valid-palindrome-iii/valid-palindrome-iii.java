class Solution {
    int[][] dp;

    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return minRemove(s, 0, s.length() - 1) <= k;
    }

    private int minRemove(String s, int i, int j) {
        if (j < i)  return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (i == j) {
            dp[i][j] = 0;
        } else if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = minRemove(s, i + 1, j - 1);
        } else {
            dp[i][j] = Math.min(minRemove(s, i, j - 1), minRemove(s, i + 1, j)) + 1;
        }
        return dp[i][j];
    }
}