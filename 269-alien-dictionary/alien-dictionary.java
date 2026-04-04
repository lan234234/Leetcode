class Solution {
    public String alienOrder(String[] words) {
        int[] degree = new int[26];
        List<List<Integer>> graph = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < 26; i++) {
            degree[i] = -1;
            graph.add(new ArrayList<>());
        }

        // 1. get all letters
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (degree[index] == -1) {
                    degree[index] = 0;
                    count++;
                }    
            }
        }

        // 2. construct graph
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            if (s2.length() < s1.length() && s1.startsWith(s2))   return "";
            for (int j = 0; j < s1.length() && j < s2.length(); j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1 - 'a').add(c2 - 'a');
                    degree[c2 - 'a']++;
                    break;
                }
            }
        }

        // 3. bfs
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append((char) (cur + 'a'));
            for (int nei : graph.get(cur)) {
                degree[nei]--;
                if (degree[nei] == 0)   q.offer(nei);
            }
        }
        
        return count == sb.length() ? sb.toString() : "";
    }
}