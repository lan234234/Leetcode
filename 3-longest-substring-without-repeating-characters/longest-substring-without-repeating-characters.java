class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] last = new int[256];
        Arrays.fill(last, -1);

        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (last[c] != -1) {
                i = Math.max(i, last[c] + 1);
            }
            last[c] = j;
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}