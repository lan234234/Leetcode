package dp;

/**
 * Determine the largest square surrounded by a bunch of matches
 * (each match is either horizontal or vertical),
 * return the length of the largest square.
 *
 * The input is a matrix of points. Each point has one of the following values:
 *
 * 0 - there is no match to its right or bottom.
 *
 * 1 - there is a match to its right.
 *
 * 2 - there is a match to its bottom.
 *
 * 3 - there is a match to its right, and a match to its bottom.
 */
public class LargestSquareOfMatches_638 {
    public int largestSquareOfMatches(int[][] matrix) {
        // assume matrix is not null
        // assume matrix only contains 0, 1, 2, 3
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // dpH[i][j] represents the longest length of consecutive horizontal matches end with matrix[i][j]
        int[][] dpH = new int[row][col];
        // dpV[i][j] represents the longest length of consecutive vertical matches end with matrix[i][j]
        int[][] dpV = new int[row][col];
        int max = 0;	// record the max length
        // iterate over the lower right corner of all possible squares
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i != 0 && (matrix[i - 1][j] == 2 || matrix[i - 1][j] == 3)) {
                    dpV[i][j] = dpV[i - 1][j] + 1;
                }
                if (j != 0 && (matrix[i][j - 1] == 1 || matrix[i][j - 1] == 3)) {
                    dpH[i][j] = dpH[i][j - 1] + 1;
                }
                // iterate over all possible length of the square
                for (int maxL = Math.min(dpV[i][j], dpH[i][j]); maxL >= 0; maxL--) {
                    if (dpH[i - maxL][j] >= maxL && dpV[i][j - maxL] >= maxL) {
                        max = Math.max(max, maxL);
                        break;
                    }
                }
            }
        }
        return max;
    }

}
