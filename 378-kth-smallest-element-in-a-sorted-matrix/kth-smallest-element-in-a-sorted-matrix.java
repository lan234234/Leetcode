class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]));

        int min = Math.min(k, n);
        for (int r = 0; r < min; r++) {
            minHeap.offer(new int[]{r, 0});
        }

        while (k > 1) {
            int[] cur = minHeap.poll();
            k--;
            cur[1]++;
            if (cur[1] < n) {
                minHeap.offer(cur);
            }
        }
        int[] cur = minHeap.peek();
        return matrix[cur[0]][cur[1]];
    }
}