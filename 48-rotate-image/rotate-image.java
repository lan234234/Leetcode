class Solution {
    /**
    [r, c] -> [c, n - 1 - r] -> [n - 1 - r, n - 1 - c] -> [n - 1 - c, r]
    [1, 0]    [0, 2]    [2, 3]  [3,1]
    [r, c]
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n / 2; r++) {
            for (int c = r; c < n - 1 - r; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[n - 1 - c][r];
                matrix[n - 1 - c][r] = matrix[n - 1 - r][n - 1 - c];
                matrix[n - 1 - r][n - 1 - c] = matrix[c][n - 1 - r];
                matrix[c][n - 1 - r] = temp;
            }
        }
    }
}