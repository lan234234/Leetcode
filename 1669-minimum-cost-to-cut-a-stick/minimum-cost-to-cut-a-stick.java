class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[][] dp = new int[m + 2][m + 2];
        Arrays.sort(cuts);
        int[] points = new int[m + 2];
        for (int i = 0; i < m; i++) {
            points[i + 1] = cuts[i];
        }
        points[m + 1] = n;
        
        for (int step = 2; step <= m + 1; step++) {
            for (int i = 0; i + step <= m + 1; i++) {
                int j = i + step;
                for (int mid = i + 1; mid < j; mid++) {
                    int cost = points[j] - points[i] + dp[i][mid] + dp[mid][j];
                    if (dp[i][j] == 0 || dp[i][j] > cost) {
                        dp[i][j] = cost;
                    }
                }
                
            }
        }
        return dp[0][m + 1];
    }
}