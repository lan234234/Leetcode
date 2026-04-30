class Solution {
    int n;
    int[][] dp;
    public boolean isValidPalindrome(String s, int k) {
        n = s.length();
        if (n <= k) return true;

        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (len == 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[0][n - 1] <= k;
    }
}
/**
0 1 2 3 4 5 6 7
b a c a b a a a

      0 1 2 3 4 5 6 7
0   [[0,1,2,1,0,1,2,0],
1    [0,0,1,0,1,2,1,0],
2    [0,0,0,1,2,1,2,0],
3    [0,0,0,0,1,0,1,0],
4    [0,0,0,0,0,1,1,0],
5    [0,0,0,0,0,0,0,0],
6    [0,0,0,0,0,0,0,0],
7    [0,0,0,0,0,0,0,0]]

 */