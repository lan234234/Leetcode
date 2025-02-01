package dp;

public class JumpGameV_1340 {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, dfs(arr, d, dp, i));
        }
        return res;
    }

    private int dfs(int[] arr, int d, int[] dp, int index) {
        if (dp[index] != 0) return dp[index];

        int res = 1;
        for (int step = 1; step <= d && index + step < arr.length && arr[index + step] < arr[index]; step++) {
            res = Math.max(res, 1 + dfs(arr, d, dp, index + step));
        }
        for (int step = 1; step <= d && index - step >= 0 && arr[index - step] < arr[index]; step++) {
            res = Math.max(res, 1 + dfs(arr, d, dp, index - step));
        }
        dp[index] = res;
        return res;
    }
}
