class Solution {
    Map<Character, List<Character>> map;
    StringBuilder sb;
    public String alienOrder(String[] words) {
        map = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                map.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            if (s2.length() < s1.length() && s1.startsWith(s2)) return "";
            for (int j = 0; j < s1.length(); j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2) {
                    map.get(c1).add(c2);
                    break;
                }
            }
        }

        sb = new StringBuilder();
        boolean[] visited = new boolean[26];
        boolean[] inPath = new boolean[26];
        for (char key : map.keySet()) {
            if (!isValid(key, visited, inPath)) return "";
        }
        
        return sb.reverse().toString();
    }

    private boolean isValid(char c, boolean[] visited, boolean[] inPath) {
        int index = c - 'a';
        if (inPath[index])  return false;
        if (visited[index]) return true;

        inPath[index] = true;
        for (char nei : map.get(c)) {
            if (!isValid(nei, visited, inPath)) return false;
        }
        visited[index] = true;
        sb.append(c);
        inPath[index] = false;
        return true;
    }
}