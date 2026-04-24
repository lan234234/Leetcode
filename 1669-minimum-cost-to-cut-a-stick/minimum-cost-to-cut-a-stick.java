class Solution {
    int[][] dp;
    int[] points;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        dp = new int[m + 2][m + 2];
        Arrays.sort(cuts);
        points = new int[m + 2];
        for (int i = 0; i < m; i++) {
            points[i + 1] = cuts[i];
        }
        points[m + 1] = n;
        return minCost(0, m + 1);
    }

    private int minCost(int i, int j) {
        int[][] temp = this.dp;
        if (j == i + 1)   return 0;
        if (dp[i][j] != 0)    return dp[i][j];

        for (int cut = i + 1; cut < j; cut++) {
            int cost = points[j] - points[i] + minCost(i, cut) + minCost(cut, j);
            if (dp[i][j] == 0 || dp[i][j] > cost) {
                dp[i][j] = cost;
            }
        }
        return dp[i][j];
    }
}