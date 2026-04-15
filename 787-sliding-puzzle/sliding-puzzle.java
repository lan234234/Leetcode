class Solution {
    /**
    input               output
    int[][] board       int moves
    [[1,2,3],
     [4,5,0]]           0
    [[1,2,0],
     [4,5,3]]           1
    
    
    assume board is not null/empty
    assume board is 2 * 3
    assume board only includes 0-5, each number appears only once
    
    bfs
    int[][] dirs: dirs[i] represent the next position of element in i
    dirs[0] = {1, 3}
    dirs[1] = {0, 2, 4}
    board -> 1d array -> "123450"
    [[1,2,0],
     [4,5,3]]   -> [1,2,0,4,5,3]    -> [120453] -> move first element -> nei
                                                -> move second element
     */
    
    int[][] dirs;
    public int slidingPuzzle(int[][] board) {
        String TARGET = "123450";
        String initial = convertToString(board);

        // corner case
        if (TARGET.equals(initial)) return 0;

        dirs = new int[][]{
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int move = 0;
        q.offer(initial);
        visited.add(initial);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(TARGET))   return move;
                int j = s.indexOf('0');
                char[] arr = s.toCharArray();
                for (int next : dirs[j]) {
                    swap(arr, j, next);
                    String cur = new String(arr);
                    if (!visited.contains(cur)) {
                        q.offer(cur);
                        visited.add(cur);
                    }
                    swap(arr, j, next);
                }
            }
            move++;
        }
        return -1;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private String convertToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j< 3; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }
}