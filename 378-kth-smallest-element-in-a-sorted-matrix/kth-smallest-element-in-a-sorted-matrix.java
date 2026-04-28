class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]));
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}};

        minHeap.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (k > 1) {
            int[] cur = minHeap.poll();
            k--;
            for (int[] dir : dirs) {
                int r = dir[0] + cur[0];
                int c = dir[1] + cur[1];
                if (r < n && c < n && !visited[r][c]) {
                    minHeap.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        int[] cur = minHeap.peek();
        return matrix[cur[0]][cur[1]];
    }
}