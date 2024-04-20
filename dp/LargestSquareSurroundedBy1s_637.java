package dp;

/**
 * Determine the largest square surrounded by 1s in a binary matrix
 * (a binary matrix only contains 0 and 1), return the length of the largest square.
 */
public class LargestSquareSurroundedBy1s_637 {
    public int largestSquareSurroundedBy1s(int[][] matrix) {
        // assume matrix is not null
        // assume matrix only contains 1 and 0
        // corner case:
        if (matrix.length == 0) {
            return 0;
        }
        // general case:
        int row = matrix.length;
        int column = matrix[0].length;
        // dpH[i][j] represents the longest consecutive 1s end with matrix[i][j] in current row
        int[][] dpH = new int[row][column];
        // dpV[i][j] represents the longest consecutive 1s end with matrix[i][j] in current column
        int[][] dpV = new int[row][column];
        helper(matrix, dpH, dpV);
        int result = 0;
        // iterate over all possible upper left corner
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                if (i == 3 && j == 3) {
                    System.out.println(1);
                }
                int maxLength = Math.min(dpH[i][j], dpV[i][j]);
                // iterate over all possible length of the square
                for (int k = maxLength; k >= 1; k--) {
                    if (dpV[i][j - k + 1] >= k && dpH[i - k + 1][j] >= k) {
                        result = Math.max(k, result);
                        break;
                    }
                }
            }
        }
        return result;
    }
    // calculate all elements values in dpH and dpV
    private void helper(int[][] matrix, int[][] dpH, int[][] dpV) {
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1) {
                    dpH[i][j] = j == 0 ? 1 : dpH[i][j - 1] + 1;
                    dpV[i][j] = i == 0 ? 1 : dpV[i - 1][j] + 1;
                }
            }
        }
    }

}
