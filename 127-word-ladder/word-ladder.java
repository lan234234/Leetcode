class Solution {
    /**
    input                                               output
    String begin    String end  List<String> dicts      int num
    "aa"            "ac"        "ab"                    0
    "aa"            "ac"        "ac"                    2
    "aa"            "bb"        "ab","bb","ac"          3
    
    assume neither begin nor end is null or empty
    assume dicts is null or empty
    assume begin.length() == end.length()
    
    bfs:
    dicts -> Map<String, List<String>> key: "*b"
    
    "ab" -> "*b"
            "a*"
    
    TC: dicts.size() * l + dicts.size() * l
    SC: dicts.size()

     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // corner case
        boolean found = false;
        for (String s : wordList) {
            if (s.equals(endWord)) {
                found = true;
                break;
            }
        }
        if (!found) return 0;

        Map<String, List<String>> map = new HashMap<>();
        for (String s: wordList) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                arr[i] = '*';
                String cur = new String(arr);
                map.putIfAbsent(cur, new ArrayList<>());
                map.get(cur).add(s);
                arr[i] = c;
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int step = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(endWord))  return step;
                char[] arr = s.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char c = arr[j];
                    arr[j] = '*';
                    String cur = new String(arr);
                    for (String nei : map.getOrDefault(cur, new ArrayList<>())) {
                        if (!visited.contains(nei)) {
                            q.offer(nei);
                            visited.add(nei);
                        }
                    }
                    arr[j] = c;
                }
            }
            step++;
        }
        return 0;
    }
}