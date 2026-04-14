class Solution {
    public int characterReplacement(String s, int k) {
        int longest = Math.min(s.length(), k);
        int[] freq = new int[26];
        int maxFreq = 0;
        int left = 0;
        int right;
        for (right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            freq[index]++;
            maxFreq = Math.max(maxFreq, freq[index]);
            if (right - left + 1 - maxFreq > k) {
                longest = Math.max(longest, right - left);
                freq[s.charAt(left++) - 'A']--;
            }
        }
        longest = Math.max(longest, right - left);
        return longest;
    }
}