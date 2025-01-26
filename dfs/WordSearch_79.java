package dfs;

public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        int len = word.length();
        int m = board.length;
        int n = board[0].length;
        // corner case:
        if (len > m * n)    return false;
        // general case:
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (dfs(row, col, board, word, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, char[][] board, String word, int index, boolean[][] visited) {
        // terminate condition
        if (index == word.length()) return true;
        if (row == board.length || row < 0 || col == board[0].length || col < 0 || visited[row][col] || board[row][col] != word.charAt(index))  return false;

        visited[row][col] = true;
        if (dfs(row + 1, col, board, word, index + 1, visited) ||
                dfs(row - 1, col, board, word, index + 1, visited) ||
                dfs(row, col + 1, board, word, index + 1, visited) ||
                dfs(row, col - 1, board, word, index + 1, visited)) return true;
        visited[row][col] = false;
        return false;
    }
}
