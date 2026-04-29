class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if (n == 1) return 1;

        int count = 0;
        boolean[][] dp = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                if (len == 1) {
                    dp[i][i] = true;
                    count++;
                } else {
                    int j = i + len - 1;
                    if (s.charAt(i) == s.charAt(j) && (i + 1 == j || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}