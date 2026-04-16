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
        List<List<Integer>> res = new ArrayList<>();
        dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 || c == 0) {
                    dfs(r, c, toPacific);
                }
                if (r == m - 1 || c == n - 1) {
                    dfs(r, c, toAtlantic);
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (toPacific[r][c] && toAtlantic[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] flow) {
        flow[r][c] = true;

        for (int[] dir : dirs) {
            int i = r + dir[0];
            int j = c + dir[1];
            if (i >= 0 && i < m && j >= 0 && j < n && !flow[i][j] && heights[i][j] >= heights[r][c]) {
                dfs(i, j, flow);
            }
        }
    }
}