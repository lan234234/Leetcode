class Solution {
    boolean[] visited;
    List<List<Integer>> graph;
    public int countComponents(int n, int[][] edges) {
        visited = new boolean[n];
        graph = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        return count;
    }

    private void dfs(int i) {
        if (visited[i]) return;

        visited[i] = true;
        for (int nei : graph.get(i)) {
            dfs(nei);
        }
    }
}