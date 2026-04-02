class Solution {
    List<List<Integer>> graph;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int[] order = new int[numCourses];
        int index = 0;
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            degree[pre[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            order[index++] = cur;
            for (int nei : graph.get(cur)) {
                degree[nei]--;
                if (degree[nei] == 0)   q.offer(nei);
            }
        }
        return index == numCourses ? order : new int[0];
    }
}