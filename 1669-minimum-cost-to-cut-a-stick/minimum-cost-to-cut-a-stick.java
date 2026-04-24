class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[][] dp = new int[m + 2][m + 2];

        int[] arr = new int[m + 2];
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        arr[m + 1] = n;

        for (int step = 2; step <= m + 1; step++) {
            for (int i = 0; i + step <= m + 1; i++) {
                int j = i + step;
                int len = arr[j] - arr[i];
                dp[i][j] = Integer.MAX_VALUE;
                for (int cut = i + 1; cut < j; cut++) {
                    int cost = len + dp[i][cut] + dp[cut][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                } 
            }
        }
        return dp[0][m + 1];
    }
}