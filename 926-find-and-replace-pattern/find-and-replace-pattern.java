class Solution {
    int[] map;
    int[] reverse;

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        map = new int[26];
        reverse = new int[26];
        
        for (String word : words) {
            if (isValid(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isValid(String word, String pattern) {
            Arrays.fill(map, -1);
            Arrays.fill(reverse, -1);
            for (int i = 0; i < word.length(); i++) {
                int cInd = pattern.charAt(i) - 'a';
                int toInd = word.charAt(i) - 'a';
                if (map[cInd] != -1 && map[cInd] != toInd)  return false;
                if (reverse[toInd] != -1 && reverse[toInd] != cInd) return false;
                map[cInd] = toInd;
                reverse[toInd] = cInd;
            }
            return true;
    }
}