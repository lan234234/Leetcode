class Solution {
    int[] arr;
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        dp = new int[m + 2][m + 2];

        arr = new int[m + 2];
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        arr[m + 1] = n;

        return minCost(0, m + 1);
    }

    private int minCost(int left, int right) {
        if (right == left + 1)  return 0;
        if (dp[left][right] != 0)   return dp[left][right];

        int len = arr[right] - arr[left];
        dp[left][right] = Integer.MAX_VALUE;
        for (int cut = left + 1; cut < right; cut++) {
            int cost = len + minCost(left, cut) + minCost(cut, right);
            dp[left][right] = Math.min(dp[left][right], cost);
        }
        return dp[left][right];
    }
}