package bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SnakesLadders_909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int max = n * n;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[max + 1];
        q.offer(1);
        visited[1] = true;

        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int cur = q.poll();
                size--;
                for (int next = 1 + cur; next - cur <= 6 && next <= max; next++) {
                    int[] pos = getPos(next, n);
                    int des = board[pos[0]][pos[1]] == -1 ? next : board[pos[0]][pos[1]];
                    if (des == max)    return res + 1;
                    if (visited[des])  continue;
                    q.offer(des);
                    visited[des] = true;
                }

            }
            res++;
        }
        return -1;
    }

    private int[] getPos(int num, int n) {
        int row = n - 1 - (num - 1) / n;
        int col = (num - 1) % n;
        col = (row + n - 1) % 2 == 0 ? col : n - 1 - col;
        return new int[]{row, col};
    }
}
