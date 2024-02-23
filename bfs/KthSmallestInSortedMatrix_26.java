package bfs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix_26 {
    public int kthSmallestInSortedMatrix(int[][] matrix, int k) {
        // assume k > 0 and k <= matrix.length * matrix[0].length
        // assume matrix is not null or empty
        // if visited[i][j] is 1, it means matrix[i][j] has been visited
        // otherwise it is not visited
        int[][] visited = new int[matrix.length][matrix[0].length];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (matrix[arr1[0]][arr1[1]] == matrix[arr2[0]][arr2[1]]) {
                    return 0;
                }
// the index with smaller value has priority
                return matrix[arr1[0]][arr1[1]] < matrix[arr2[0]][arr2[1]] ? -1 : 1;
            }
        });
        minHeap.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while (k > 1) {
            int[] cur = minHeap.poll();
            k--;
            update(cur, matrix, minHeap, visited);
        }
        int[] index = minHeap.poll();
        return matrix[index[0]][index[1]];
    }
    private void update(int[] cur, int[][] matrix, PriorityQueue<int[]> minHeap, int[][] visited) {
        int[][] directions = {{1, 0}, {0, 1}};
        for (int[] direction : directions) {
            int row = cur[0] + direction[0];
            int col = cur[1] + direction[1];
            // if the neighbor's index is valid and the element is not visited
            if (row < matrix.length && col < matrix[0].length && visited[row][col] == 0) {
                minHeap.offer(new int[]{row, col});
                visited[row][col] = 1;
            }
        }
    }

}
