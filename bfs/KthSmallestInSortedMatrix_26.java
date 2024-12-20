package bfs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix_26 {

    /**
     * method 1: minHeap + BFS
     * TC: O(klogk)
     * SC: O(k)
     */
    public int solution1(int[][] matrix, int k) {
        int n = matrix.length;
        boolean[][] visited = new boolean[n][n];
        int[][] steps = new int[][]{{0, 1}, {1, 0}};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((arr1, arr2) -> (matrix[arr1[0]][arr1[1]] - matrix[arr2[0]][arr2[1]]));
        minHeap.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (k > 1) {
            int[] cur = minHeap.poll();
            k--;
            for (int[] step : steps) {
                int row = cur[0] + step[0];
                int col = cur[1] + step[1];
                if (row < n && col < n && !visited[row][col]) {
                    minHeap.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
        int[] arr = minHeap.peek();
        return matrix[arr[0]][arr[1]];
    }

}
