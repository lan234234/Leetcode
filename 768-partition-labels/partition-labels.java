class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        while (start < s.length()) {
            int end = start;
            for (int i = start; i <= end; i++) {
                if (last[s.charAt(i) - 'a'] > end) {
                    end = last[s.charAt(i) - 'a'];
                }
            }
            res.add(end - start + 1);
            start = end + 1;
        }
        return res;
    }
}