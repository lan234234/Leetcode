package hashtable;

public class SudukoSolver_37 {
    char[][] board;
    int N;
    int BLOCK_SIZE;
    int[] rows;
    int[] cols;
    int[] subBoxes;
    int[] bitMap;
    int filledCount;
    public void solveSudoku(char[][] board) {
        this.board = board;
        N = board.length;
        BLOCK_SIZE = 3;
        rows = new int[N];
        cols = new int[N];
        subBoxes = new int[N];
        bitMap = new int[]{1, 1 << 1, 1 << 2, 1 << 3, 1 << 4, 1 << 5, 1 << 6, 1 << 7, 1 << 8};
        filledCount = 0;

        // initialize
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == '.') continue;
                mark(r, c, board[r][c] - '1');
            }
        }
        dfs();
    }

    private boolean dfs() {
        // base case:
        if (filledCount == N * N)   return true;

        int[] posWithMinNumCandidates = getPosWithMinNumCandidates();
        int row = posWithMinNumCandidates[0];
        if (row == -1)  return false;
        int col = posWithMinNumCandidates[1];
        for (int pos = 0; pos < N; pos++) {
            if (isValid(row, col, pos)) {
                board[row][col] = (char) (pos + '1');
                mark(row, col, pos);
                if (dfs())  return true;
                board[row][col] = '.';
                unMark(row, col, pos);
            }
        }
        return false;
    }

    private int[] getPosWithMinNumCandidates() {
        int min = 10;
        int row = -1;
        int col = -1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] != '.') continue;
                int num = countCandidates(r, c);
                if (num == 0)   return new int[]{-1, -1};
                if (num < min) {
                    min = num;
                    row = r;
                    col = c;
                }
                if (min == 1)   break;
            }
        }
        return new int[]{row, col};
    }

    private int countCandidates(int row, int col) {
        int possibleCandidates = ~(rows[row] | cols[col] | subBoxes[row / BLOCK_SIZE * BLOCK_SIZE + col / BLOCK_SIZE]) & 0b111111111;
        int count = 0;
        while (possibleCandidates > 0) {
            count++;
            possibleCandidates &= possibleCandidates - 1;
        }
        return count;
    }

    private boolean isValid(int row, int col, int pos) {
        return (rows[row] & bitMap[pos]) == 0 && (cols[col] & bitMap[pos]) == 0 && (subBoxes[row / BLOCK_SIZE * BLOCK_SIZE + col / BLOCK_SIZE] & bitMap[pos]) == 0;
    }

    private void mark(int row, int col, int pos) {
        filledCount++;
        rows[row] |= bitMap[pos];
        cols[col] |= bitMap[pos];
        subBoxes[row / BLOCK_SIZE * BLOCK_SIZE + col / BLOCK_SIZE] |= bitMap[pos];
    }

    private void unMark(int row, int col, int pos) {
        filledCount--;
        rows[row] &= ~bitMap[pos];
        cols[col] &= ~bitMap[pos];
        subBoxes[row / BLOCK_SIZE * BLOCK_SIZE + col / BLOCK_SIZE] &= ~bitMap[pos];
    }
}
