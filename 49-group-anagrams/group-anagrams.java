class Solution {
    /**
    1. sort -> group
    sort: llogl * n
    map: l * n

    2. map
    word -> char map-> string    l

    
    
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sortedS = sort(s);
            map.putIfAbsent(sortedS, new ArrayList<>());
            map.get(sortedS).add(s);
        }

        List<List<String>> list = new ArrayList<>();
        for (List<String> cur : map.values()) {
            list.add(cur);
        }
        return list;
    }

    private String sort(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                sb.append(freq[i]);
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}