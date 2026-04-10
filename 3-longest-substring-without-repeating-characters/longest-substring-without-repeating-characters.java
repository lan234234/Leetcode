class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] last = new int[256];
        Arrays.fill(last, -1);

        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (last[c] != -1) {
                res = Math.max(res, j - i);
                while (i <= last[c]) {
                    last[s.charAt(i)] = -1;
                    i++;
                }
            }
            last[c] = j;
        }
        res = Math.max(s.length() - i, res);
        return res;
    }
}