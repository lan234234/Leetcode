class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String compressedS = compress(s);
            map.putIfAbsent(compressedS, new ArrayList<>());
            map.get(compressedS).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String compress(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                sb.append((char) (i + 'a'));
                sb.append(freq[i]);
            }
        }
        return sb.toString();
    }
}