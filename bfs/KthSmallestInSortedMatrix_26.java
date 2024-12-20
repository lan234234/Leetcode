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

    /**
     * method 2: minHeap
     * TC: O((min + k)logmin)
     * SC: O(min)
     * min = Math.min(k, n)
     */
    public int solution2(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((arr1, arr2) -> (matrix[arr1[0]][arr1[1]] - matrix[arr2[0]][arr2[1]]));
        int min = Math.min(k, n);
        for (int i = 0; i < min; i++) {
            minHeap.offer(new int[]{i, 0});
        }
        while (k > 1) {
            int[] cur = minHeap.poll();
            k--;
            if (cur[1] == n - 1)    continue;
            minHeap.offer(new int[]{cur[0], cur[1] + 1});
        }
        int[] arr = minHeap.peek();
        return matrix[arr[0]][arr[1]];
    }

    /**
     * method 3: binary search
     * TC: O(nlog(maxDiff)) = O(n)
     * SC: O(1)
     */
    public int solution3(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        int result = left;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = countSmallerOrEqual(mid, matrix);
            if (count >= k) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int countSmallerOrEqual(int num, int[][] matrix) {
        int count = 0;
        int row = 0;
        int n = matrix.length;
        int col = n - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] > num) {
                col--;
            } else {
                count += col + 1;
                row++;
            }
        }
        return count;
    }

}
