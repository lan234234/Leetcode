class Solution {
    int n;
    Integer[][] dp;
    public boolean isValidPalindrome(String s, int k) {
        n = s.length();
        if (n <= k) return true;

        dp = new Integer[n][n];
        return minRemove(s, 0, n - 1) <= k;
    }

    private int minRemove(String s, int i, int j) {
        if (dp[i][j] != null)   return dp[i][j];
        
        if (i == j) {
            dp[i][j] = 0;
        } else if (i + 1 == j) {
            dp[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = minRemove(s, i + 1, j - 1);
        } else {
            dp[i][j] = 1 + Math.min(minRemove(s, i + 1, j), minRemove(s, i, j - 1));
        }
        return dp[i][j];
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