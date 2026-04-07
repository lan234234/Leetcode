class Solution {
    int N;
    boolean[] cols;
    boolean[] diag;
    boolean[] diag2;
    int count;

    public int totalNQueens(int n) {
        N = n;
        cols = new boolean[n];
        diag = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        count = 0;

        dfs(0);
        return count;
    }

    private boolean dfs(int row) {
        if (row == N)   count++;

        for (int col = 0; col < N; col++) {
            if (cols[col] || diag[row - col + N - 1] || diag2[row + col])   continue;
            cols[col] = true;
            diag[row - col + N - 1] = true;
            diag2[row + col] = true;
            if (dfs(row + 1))   return true;
            cols[col] = false;
            diag[row - col + N - 1] = false;
            diag2[row + col] = false;
        }
        return false;
    }
}