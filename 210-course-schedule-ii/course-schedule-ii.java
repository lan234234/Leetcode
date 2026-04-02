class Solution {
    List<List<Integer>> graph;
    int[] order;
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        order = new int[numCourses];
        index = numCourses - 1;
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!isValid(i, visited, inPath))   return new int[0];
            }
        }
        
        return order;
    }

    private boolean isValid(int cur, boolean[] visited, boolean[] inPath) {
        if (inPath[cur])    return false;
        if(visited[cur])    return true;

        inPath[cur] = true;
        for (int nei : graph.get(cur)) {
            if (!isValid(nei, visited, inPath)) return false;
        }
        visited[cur] = true;
        order[index--] = cur;
        inPath[cur] = false;
        return true;
    }
}