class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] matrix = new int[rows][cols];
        int max = rows * cols;
        int[][] res = new int[max][2];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int r = rStart, c = cStart;
        int dirIndex = 0;
        int count = 0;

        // Mark starting position
        matrix[r][c] = 1;
        res[count++] = new int[]{r, c};

        while (count < max) {
            // Find next position logic
            int nextR = r + dirs[dirIndex][0];
            int nextC = c + dirs[dirIndex][1];

            // Loop until we find a valid move based on your rules
            // if next position is out of bound -> stay here + turn dir
            // if it has been filled -> back to origianl pos + keep original dir
            while (!isValid(nextR, nextC, rows, cols) || matrix[nextR][nextC] != 0) {
                if (!isValid(nextR, nextC, rows, cols)) {
                    r = nextR;
                    c = nextC;
                    dirIndex = (dirIndex + 1) % 4;
                } else {
                    dirIndex = (dirIndex + 3) % 4;
                }
                nextR = r + dirs[dirIndex][0];
                nextC = c + dirs[dirIndex][1];
            }

            // Move to the found position
            r = nextR;
            c = nextC;
            dirIndex = (dirIndex + 1) % 4;

            // Mark and store
            matrix[r][c] = 1;
            res[count++] = new int[]{r, c};
        }
        return res;
    }

    private boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}