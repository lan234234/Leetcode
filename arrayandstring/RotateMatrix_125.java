package arrayandstring;

/**
 * Rotate an N * N matrix clockwise 90 degrees.
 */
public class RotateMatrix_125 {
    public void rotateMatrix(int[][] matrix) {
        // corner case:
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        // general case:
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

}
