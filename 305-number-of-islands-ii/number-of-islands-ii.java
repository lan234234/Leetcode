class Solution {
    int[] root;
    int[] rank;
    int size;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        List<Integer> res = new ArrayList<>();
        root = new int[m * n];
        rank = new int[m * n];
        size = 0;

        Arrays.fill(root, -1);

        for (int[] pos : positions) {
            int index = pos[0] * n + pos[1];
            if (root[index] != -1) {
                res.add(size);
                continue;
            }
            root[index] = index;
            size++;

            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                int nextIndex = r * n + c;
                if (r < 0 || r >= m || c < 0 || c >= n || root[nextIndex] == -1) continue;
                merge(index, nextIndex);
            }
            res.add(size);
        }
        return res;
    }

    private void merge(int index1, int index2) {
        int root1 = findRoot(index1);
        int root2 = findRoot(index2);
        if (root1 == root2) return;
        size--;
        if (rank[root1] > rank[root2]) {
            root[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
            root[root1] = root2;
        } else {
            root[root2] = root1;
            rank[root1]++;
        }
    }

    private int findRoot(int index) {
        if (index == root[index])   return index;
        root[index] = findRoot(root[index]);
        return root[index];
    }
}