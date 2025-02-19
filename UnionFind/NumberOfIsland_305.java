package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIsland_305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int color = 1;
        int count = 0;  // count map
        int[] map = new int[10001];
        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
            if (grid[position[0]][position[1]] == 0) {
                grid[position[0]][position[1]] = color;
                for (int[] dir : dirs) {
                    int row = dir[0] + position[0];
                    int col = dir[1] + position[1];
                    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)   continue;

                    int curCol = grid[row][col];
                    grid[row][col] = color;
                    while (map[curCol] != 0 && map[curCol] != color) {
                        int temp = map[curCol];
                        map[curCol] = color;
                        curCol = temp;
                    }
                    if (map[curCol] == 0) {
                        count++;
                        map[curCol] = color;
                    }

                }
                color++;
            }


            res.add(color - count - 1);
        }
        return res;
    }
}
