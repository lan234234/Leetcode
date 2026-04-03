class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = '*';
                String cur = new String(arr);
                map.putIfAbsent(cur, new ArrayList<>());
                map.get(cur).add(word);
                arr[i] = word.charAt(i);
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int step = 1;
        q.offer(beginWord);
        visited.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord))    return step;
                char[] arr = word.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = '*';
                    List<String> next = map.get(new String(arr));
                    if (next != null) {
                        for (String cur : next) {
                            if (visited.contains(cur))   continue;
                            q.offer(cur);
                            visited.add(cur);
                        }
                    }
                    
                    arr[j] = word.charAt(j);
                }
            }
            step++;
        }
        return 0;
    }
}