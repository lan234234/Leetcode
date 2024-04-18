package dp;

/**
 * Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1),
 * return the length of the largest square.
 */
public class LargestSquareOf1s_101 {
    public int largestSquareOf1s(int[][] matrix) {
        // corner case:
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // general case:
        int max = 0;
        // dp[i][j] represents the largest length of square with point(i, j) as right-bottom corner
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (matrix[i][j] != 0) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) +  1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

}
