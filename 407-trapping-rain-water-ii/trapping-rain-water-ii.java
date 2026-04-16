class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int res = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (heightMap[a[0]][a[1]] - heightMap[b[0]][b[1]]));
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 || r == m - 1 || c == 0 || c == n - 1) {
                    minHeap.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int curH = heightMap[cur[0]][cur[1]];
            for (int[] dir : dirs) {
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c])    continue;
                if (curH > heightMap[r][c]) {
                    res += curH - heightMap[r][c];
                    heightMap[r][c] = curH;
                }
                minHeap.offer(new int[]{r, c});
                visited[r][c] = true;
            }
        }
        return res;
    }
}