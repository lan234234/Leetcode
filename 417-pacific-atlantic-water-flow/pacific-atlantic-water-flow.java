class Solution {
    int m;
    int n;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] toPacific = new boolean[m][n];
        boolean[][] toAtlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    toPacific[i][j] = true;
                }
                if (i == m - 1 || j == n - 1) {
                    toAtlantic[i][j] = true;
                }
            }
        }

        bfs(heights, toPacific);
        bfs(heights, toAtlantic);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (toAtlantic[i][j] && toPacific[i][j])   res.add(List.of(i, j));
            }
        }
        return res;
    }

    private void bfs(int[][] heights, boolean[][] flow) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flow[i][j]) q.offer(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int r = dir[0] + cur[0];
                int c = dir[1] + cur[1];
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    flow[r][c] || heights[r][c] < heights[cur[0]][cur[1]]) continue;
                flow[r][c] = true;
                q.offer(new int[]{r, c});
            }
        }
    }
}