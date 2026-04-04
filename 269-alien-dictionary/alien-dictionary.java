class Solution {
    Map<Character, List<Character>> graph;
    StringBuilder sb;

    public String alienOrder(String[] words) {
        graph = new HashMap<>();
        sb = new StringBuilder();

        // 1. get all letters
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                graph.putIfAbsent(word.charAt(i), new ArrayList<>());   
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
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }

        // 3. dfs
        boolean[] visited = new boolean[26];
        boolean[] inPath = new boolean[26];
        for (char key : graph.keySet()) {
            if (!isValid(key, visited, inPath)) return "";
        }

        return sb.reverse().toString();
    }

    private boolean isValid(char c, boolean[] visited, boolean[] inPath) {
        int index = c - 'a';
        if (inPath[index])    return false;
        if (visited[index])   return true;

        inPath[index] = true;
        for (char nei : graph.get(c)) {
            if (!isValid(nei, visited, inPath)) return false;
        }
        visited[index] = true;
        sb.append(c);
        inPath[index] = false;
        return true;
    }
}