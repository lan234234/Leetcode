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
    dicts -> set
    visited set
    "aa" -> "?a" (26 possible)
         -> "a?" (26 possible) -> "ab" "ac"
    
    TC: dicts.size() * l * 26
    SC: dicts.size()

     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        // corner case
        if (!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        set.remove(beginWord);
        int step = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(endWord))  return step;
                char[] arr = s.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char c = arr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch != c) {
                            arr[j] = ch;
                            String cur = new String(arr);
                            if (set.contains(cur)) {
                                q.offer(cur);
                                set.remove(cur);
                            }
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