class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isValid(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isValid(String s, String pattern) {
        int[] map = new int[26];
        int[] reverseMap = new int[26];
        Arrays.fill(map, -1);
        Arrays.fill(reverseMap, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int patInd = pattern.charAt(i) - 'a';
            if (map[index] != -1 && map[index] != patInd)   return false;
            if (reverseMap[patInd] != -1 && reverseMap[patInd] != index)  return false;
            map[index] = patInd;
            reverseMap[patInd] = index;
        }
        return true;
    }
}