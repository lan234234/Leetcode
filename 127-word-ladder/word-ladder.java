class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))  return 1;

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))    return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int count = 1;
        q.offer(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord))    return count;
                char[] arr = cur.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char curC = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == curC)    continue;
                        arr[j] = c;
                        String next = new String(arr);
                        if (!dict.contains(next) || visited.contains(next))   continue;
                        visited.add(next);
                        q.offer(next);
                    }
                    arr[j] = curC;
                }
            }
            count++;
        }
        return 0;
    }
}