class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        if (m == 1) return n;

        int[][] dp = new int[m + 2][m + 2];
        int[] arr = new int[m + 2];
        Arrays.sort(cuts);
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        arr[m + 1] = n;

        for (int step = 2; step < m + 2; step++) {
            for (int i = 0; i + step < m + 2; i++) {
                int j = i + step;
                int len = arr[j] - arr[i];
                for (int cut = i + 1; cut < j; cut++) {
                    int cost = len + dp[i][cut] + dp[cut][j];
                    if (dp[i][j] == 0 || cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        return dp[0][m + 1];
    }
}