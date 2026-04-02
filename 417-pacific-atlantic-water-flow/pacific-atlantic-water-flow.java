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
                    if (!toPacific[i][j])   dfs(i, j, heights, toPacific);
                }
                if (i == m - 1 || j == n - 1) {
                    if (!toAtlantic[i][j])  dfs(i, j, heights, toAtlantic);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (toAtlantic[i][j] && toPacific[i][j])   res.add(List.of(i, j));
            }
        }
        return res;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] flow) {
        flow[i][j] = true;
        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            if (r < 0 || r >= m || c < 0 || c >= n || 
                flow[r][c] || heights[r][c] < heights[i][j]) continue;
            dfs(r, c, heights, flow);
        }
    }
}