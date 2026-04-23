class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int len = m * n;
        int[] res = new int[len];
        int r = 0;
        int c = 0;
        int[][] dirs = new int[][]{{-1, 1}, {1, -1}};
        int i = 0;
        int dirInd = 0;

        while (i < len) {
            if (r >= 0 && r < m && c >= 0 && c < n) {
                res[i++] = mat[r][c];
                r += dirs[dirInd][0];
                c += dirs[dirInd][1];
                continue; 
            }
            dirInd = 1 - dirInd;
            if (c == n) {
                r += 2;
                c -= 1;
            } else if (r == -1) {
                r += 1;
            } else if (r == m) {
                r -= 1;
                c += 2;
            } else {
                c += 1;
            }
        }
        return res;
    }
}