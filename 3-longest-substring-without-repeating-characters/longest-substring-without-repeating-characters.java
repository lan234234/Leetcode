class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (exist[c]) {
                exist[s.charAt(left)] = false;
                left++;
            }
            exist[c] = true;
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}