class Solution {
    Map<Character, List<Character>> map;
    public String alienOrder(String[] words) {
        map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                map.putIfAbsent(c, new ArrayList<>());
                degree.putIfAbsent(c, 0);
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
                    degree.put(c2, degree.get(c2) + 1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 0) {
                q.offer(entry.getKey());
            }
        }

        while (!q.isEmpty()) {
            Character cur = q.poll();
            sb.append(cur);
            for (char nei : map.get(cur)) {
                int deg = degree.get(nei) - 1;
                if (deg == 0) {
                    q.offer(nei);
                }
                degree.put(nei, deg);
            }
        }
        return sb.length() == degree.size() ? sb.toString() : "";
    }
}