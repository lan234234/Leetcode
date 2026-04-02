class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] dirs = new int[][]{
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };
        String TARGET = "123450";
        StringBuilder sb = new StringBuilder();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int step = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        q.offer(sb.toString());
        visited.add(sb.toString());

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (TARGET.equals(cur)) return step;
                int index = cur.indexOf('0');
                for (int nextP : dirs[index]) {
                    String next = generateNext(cur, index, nextP);
                    if (visited.contains(next)) continue;
                    q.offer(next);
                    visited.add(next);
                }
            }
            step++;
        }
        return -1;
    }

    private String generateNext(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));
        return sb.toString();
    }
}