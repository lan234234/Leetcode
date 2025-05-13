package simulation;

public class SpiralMatrixIII {
    int cur;
    int[][] matrix;
    int rows;
    int cols;
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int max = rows * cols;
        matrix = new int[max][2];
        int top = rStart;
        int bottom = rStart;
        int left = cStart;
        int right = cStart;
        cur = 0;
        this.rows = rows;
        this.cols = cols;
        // int r = rStart;
        // int c = cStart;

        while (cur < max) {
            traverseEast(top, Math.max(0, left), Math.min(cols - 1, right));
            right++;
            traverseSouth(right, Math.max(0, top), Math.min(rows - 1, bottom));
            bottom++;
            traverseWest(bottom, Math.min(right, cols - 1), Math.max(0, left));
            left--;
            traverseNorth(left, Math.min(rows - 1, bottom), Math.max(0, top));
            top--;
        }

        return matrix;
    }

    private void traverseEast(int r, int start, int end) {
        if (r < 0) return;
        for (int c = start; c <= end; c++) {
            matrix[cur][0] = r;
            matrix[cur][1] = c;
            cur++;
        }
    }

    private void traverseWest(int r, int start, int end) {
        if (r >= rows) return;
        for (int c = start; c >= end; c--) {
            matrix[cur][0] = r;
            matrix[cur][1] = c;
            cur++;
        }
    }

    private void traverseSouth(int c, int start, int end) {
        if (c >= cols) return;
        for (int r = start; r <= end; r++) {
            matrix[cur][0] = r;
            matrix[cur][1] = c;
            cur++;
        }
    }

    private void traverseNorth(int c, int start, int end) {
        if (c < 0) return;
        for (int r = start; r >= end; r--) {
            matrix[cur][0] = r;
            matrix[cur][1] = c;
            cur++;
        }
    }
}
