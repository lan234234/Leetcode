package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 *
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 */
public class WallsAndGates_503 {
    public int[][] wallsAndGates(int[][] matrix) {
        // corner case:
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        // offer the index of all 0 to queue
        offerZeros(matrix, queue);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // update neighbors
            updateNeighbors(matrix, cur, queue);
        }
        return matrix;
    }
    private void offerZeros(int[][] matrix, Queue<int[]> queue) {
        // traverse all elements in matrix, find 0 and offer them to the queue
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
    }
    private void updateNeighbors(int[][] matrix, int[] cur, Queue<int[]> queue) {
        // the distance of cur to the nearest gate
        int curDistance = matrix[cur[0]][cur[1]];
        // directions: used for calculate neighbors' index
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            int newRow = cur[0] + direction[0];
            int newCol = cur[1] + direction[1];
            // if the neighbor's index is valid
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length) {
                if (matrix[newRow][newCol] == Integer.MAX_VALUE) {
                    // update neighbor's value and offer it to queue
                    matrix[newRow][newCol] = curDistance + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
