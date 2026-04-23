class Solution {
    int[][] matrix;
    int n;
    public void rotate(int[][] matrix) {
        this.matrix = matrix;
        n = matrix.length;
        diagnalSwap();
        middleSwap();
    }

    private void middleSwap() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n / 2; c++) {
                swap(r, c, r, n - 1 - c);
            }
        }
    }

    private void diagnalSwap() {
        for (int r = 0; r < n; r++) {
            for (int c = r + 1; c < n; c++) {
                swap(r, c, c, r);
            }
        }
    }

    private void swap(int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}