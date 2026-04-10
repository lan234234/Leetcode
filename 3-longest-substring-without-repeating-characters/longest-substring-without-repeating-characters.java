class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        boolean[] exist = new boolean[256];

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            while (exist[c]) {
                exist[s.charAt(left)] = false;
                left++;
            }
            exist[c] = true;
            res = Math.max(right - left + 1, res);
            right++;
        }
        return res;
    }
}