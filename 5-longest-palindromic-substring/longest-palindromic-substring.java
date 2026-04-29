class Solution {
    int n;
    int max;
    int start;
    boolean[][] dp;
    public String longestPalindrome(String s) {
        n = s.length();
        if (n == 1)    return s;

        max = 1;
        start = 0;
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (len == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (len > max) {
                        max = len;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + max);
    }
}