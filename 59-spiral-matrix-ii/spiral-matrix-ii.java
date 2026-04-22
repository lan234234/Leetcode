class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int cur = 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                matrix[top][c] = cur++;
            }
            if (++top > bottom) break;

            for (int r = top; r <= bottom; r++) {
                matrix[r][right] = cur++;
            }
            if (--right < left) break;

            for (int c = right; c >= left; c--) {
                matrix[bottom][c] = cur++;
            }
            bottom--;

            for (int r = bottom; r >= top; r--) {
                matrix[r][left] = cur++;
            }
            left++;
        }
        return matrix;
    }
}