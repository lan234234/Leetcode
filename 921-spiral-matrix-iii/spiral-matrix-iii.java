class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int max = rows * cols;
        int[][] res = new int[max][2];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 1;
        int cycle = 2;
        
        int r = rStart, c = cStart;
        int dirIndex = 0;
        int count = 0;

        while (count < max) {
            for (int i = 0; i < cycle; i++) {
                for (int j = 0; j < step; j++) {
                    if (isValid(r, c, rows, cols)) {
                        res[count++] = new int[]{r, c};
                    }
                    r += dirs[dirIndex][0];
                    c += dirs[dirIndex][1];
                }
                dirIndex = (dirIndex + 1) % 4;
            }
            step++;
        }
        return res;
    }

    private boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}