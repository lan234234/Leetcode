package dp;

/**
 * Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s,
 * with the same arm lengths and the four arms joining at the central point.
 * Return the arm length of the largest X shape.
 */
public class LargestX1s_105 {
    public int longestCross1s(int[][] matrix) {
        // assume matrix is not null
        // assume matrix only contains 1s and 0s
        // corner case:
        if (matrix.length == 0) {
            return 0;
        }
        // general case:
        int[][] leftUp = getLeftUp(matrix);
        int[][] upLeft = getUpLeft(matrix);
        int[][] upRight = getUpRight(matrix);
        int[][] rightUp = getRightUp(matrix);
        // max used for updating the arm length of the largest cross
        int max = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1) {
                    int min1 = Math.min(leftUp[i][j], upLeft[i][j]);
                    int min2 = Math.min(upRight[i][j], rightUp[i][j]);
                    // cur used for record the arm length of the largest cross with current point as center
                    int cur = Math.min(min1, min2);
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }
    // return a 2D matrix, the elements in the matrix represents the longest length of consecutive 1s end with it in current diagonal from lower left to upper right
    private int[][] getLeftUp(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] leftUp = new int[row][column];
        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                if (matrix[i][j] == 1) {
                    leftUp[i][j] = j == 0 || i == row - 1 ? 1 : leftUp[i + 1][j - 1] + 1;
                }
            }
        }
        return leftUp;
    }

    private int[][] getUpLeft(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] upLeft = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1) {
                    upLeft[i][j] = i == 0 || j == column - 1 ? 1 : upLeft[i - 1][j + 1] + 1;
                }
            }
        }
        return upLeft;
    }

    private int[][] getUpRight(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] upRight = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1) {
                    upRight[i][j] = i == 0 || j == 0 ? 1 : upRight[i - 1][j - 1] + 1;
                }
            }
        }
        return upRight;
    }

    private int[][] getRightUp(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] rightUp = new int[row][column];
        for (int j = column - 1; j >= 0; j--) {
            for (int i = 0; i < row; i++) {
                if (matrix[i][j] == 1) {
                    rightUp[i][j] = j == column - 1 || i == row - 1 ? 1 : rightUp[i + 1][j + 1] + 1;
                }
            }
        }
        return rightUp;
    }

}
