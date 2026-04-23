class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = rStart;
        int c = cStart;
        int max = rows * cols;
        int[][] res = new int[max][];
        int count = 0;
        int step = 1;
        int dirInd = 0;

        while (count < max) {
            for (int cycle = 0; cycle < 2; cycle++) {
                for (int i = 0; i < step; i++) {
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        res[count++] = new int[]{r, c};
                    }
                    r += dirs[dirInd][0];
                    c += dirs[dirInd][1];
                }
                dirInd = (dirInd + 1) % 4;
            }
            step++;
        }
        return res;
    }
}