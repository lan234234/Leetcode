class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        if (m == 1) return n;

        dp = new int[m + 2][m + 2];
        int[] arr = new int[m + 2];
        Arrays.sort(cuts);
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        arr[m + 1] = n;
        
        return minCost(arr, 0, m + 1);
    }

    private int minCost(int[] arr, int i, int j) {
        if (i + 1 == j) return 0;
        if (dp[i][j] != 0)  return dp[i][j];

        int len = arr[j] - arr[i];
        dp[i][j] = Integer.MAX_VALUE;
        for (int cut = i + 1; cut < j; cut++) {
            int cost = len + minCost(arr, i, cut) + minCost(arr, cut, j);
            dp[i][j] = Math.min(cost, dp[i][j]);
        }
        return dp[i][j];
    }
}