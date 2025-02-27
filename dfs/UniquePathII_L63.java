package dfs;

public class UniquePathII_L63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // corner case:
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;

        // general case:
        for (int row = 0; row < obstacleGrid.length; row++) {
            for (int col = 0; col < obstacleGrid[0].length; col++) {
                obstacleGrid[row][col] = obstacleGrid[row][col] == 0 ? -1 : 0;
            }
        }

        return dfs(0, 0, obstacleGrid);
    }
    private int dfs(int row, int col, int[][] grid) {
        if (row == grid.length - 1 && col == grid[0].length - 1)    return 1;
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)  return 0;
        if (grid[row][col] != -1)    return grid[row][col];

        grid[row][col] = dfs(row + 1, col, grid) + dfs(row, col + 1, grid);
        return grid[row][col];
    }
}
