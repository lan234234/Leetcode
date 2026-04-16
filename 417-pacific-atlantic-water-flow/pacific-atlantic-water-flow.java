class Solution {
    int m;
    int n;
    int[][] heights;
    int[][] dirs;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        boolean[][] toPacific = new boolean[m][n];
        boolean[][] toAtlantic = new boolean[m][n];
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 || c == 0) {
                    toPacific[r][c] = true;
                    pacificQ.offer(new int[]{r, c});
                }
                if (r == m - 1 || c == n - 1) {
                    toAtlantic[r][c] = true;
                    atlanticQ.offer(new int[]{r, c});
                }
            }
        }

        bfs(pacificQ, toPacific);
        bfs(atlanticQ, toAtlantic);

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (toPacific[r][c] && toAtlantic[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] flow) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !flow[r][c] && heights[r][c] >= heights[cur[0]][cur[1]]) {
                    q.offer(new int[]{r, c});
                    flow[r][c] = true;
                }
            }
        }
    }
}