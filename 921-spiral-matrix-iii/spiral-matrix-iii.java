class Solution {
    int r;
    int c;
    int num;
    int dirIndex;
    int rows;
    int cols;
    int[][] matrix;
    int[][] dirs;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        matrix = new int[rows][cols];
        dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        r = rStart;
        c = cStart;
        num = 1;
        dirIndex = 0;
        this.rows = rows;
        this.cols = cols;
        int max = rows * cols;
        int[][] res = new int[max][2];

        matrix[r][c] = num++;
        res[0] = new int[]{r, c};
        while (num <= max) {
            findNextPos();
            res[num - 1] = new int[]{r, c};
            matrix[r][c] = num++;
        }
        return res;
    }

    /**
    invalidPos -> keep pos + next dir
    hasfilled -> keep cur dir
     */
    private void findNextPos() {
        int nextR = r + dirs[dirIndex][0];
        int nextC = c + dirs[dirIndex][1];
        while (!isValidPos(nextR, nextC) || isFilled(nextR, nextC)) {
            if (!isValidPos(nextR, nextC)) {
                r = nextR;
                c = nextC;
                dirIndex = (dirIndex + 1) % 4;
            } else {
                dirIndex = (dirIndex + 3) % 4;
            }
            nextR = r + dirs[dirIndex][0];
            nextC = c + dirs[dirIndex][1];
        }
        r = nextR;
        c = nextC;
        dirIndex = (dirIndex + 1) % 4;
    }

    private boolean isValidPos(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    private boolean isFilled(int r, int c) {
        return matrix[r][c] != 0;
    }
}