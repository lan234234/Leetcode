package dfs;

public class NumberOfIslands_200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == '1') {
                        count++;
                        dfs(row, col, grid);
                    }
                }
            }
            return count;
        }

        private void dfs(int row, int col, char[][] grid) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0')  return;
            grid[row][col] = '0';
            dfs(row + 1, col, grid);
            dfs(row - 1, col, grid);
            dfs(row, col + 1, grid);
            dfs(row, col - 1, grid);
        }
    }
}
