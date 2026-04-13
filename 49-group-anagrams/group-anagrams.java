class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedS = new String(arr);
            List<String> list = map.get(sortedS);
            if (list == null) {
                list = new ArrayList<>();
                map.put(sortedS, list);
            }
            list.add(s);
        }

        return new ArrayList<>(map.values());
    }
}