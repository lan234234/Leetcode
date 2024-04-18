package dp;

public class LongestCross1s_104 {
    public int longestCross1s(int[][] matrix) {
        // assume matrix is not null
        // assume matrix only contains 1s and 0s
        // corner case:
        if (matrix.length == 0) {
            return 0;
        }
        // general case:
        int[][] left = getLeftLongest(matrix);
        int[][] right = getRightLongest(matrix);
        int[][] up = getUpLongest(matrix);
        int[][] bottom = getBottomLongest(matrix);
        // max used for updating the arm length of the largest cross
        int max = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        // dp[i][j] represents the largest length of the cross with matrix[i][j] as center
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1) {
                    int min1 = Math.min(left[i][j], right[i][j]);
                    int min2 = Math.min(up[i][j], bottom[i][j]);
                    dp[i][j] = Math.min(min1, min2);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
    // return a 2D matrix, the elements in the matrix represents the longest length
    // of consecutive 1s end with it in this row
    private int[][] getLeftLongest(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] left = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                }
            }
        }
        return left;
    }

    private int[][] getRightLongest(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] right = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = column - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = j == column - 1 ? 1 : right[i][j + 1] + 1;
                }
            }
        }
        return right;
    }

    private int[][] getUpLongest(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] up = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1) {
                    up[i][j] = i == 0 ? 1 : up[i - 1][j] + 1;
                }
            }
        }
        return up;
    }

    private int[][] getBottomLongest(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] bottom = new int[row][column];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1) {
                    bottom[i][j] = i == row - 1 ? 1 : bottom[i + 1][j] + 1;
                }
            }
        }
        return bottom;
    }

}
