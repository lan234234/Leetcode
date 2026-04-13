class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        int curMaxFreq = 0;
        int[] freq = new int[26];
        int left = 0;
        int right;

        for (right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            freq[index]++;
            curMaxFreq = Math.max(curMaxFreq, freq[index]);
            // only when we encounter invalid case, update longest
            // because current invalid means before process current right, it was a valid sequence with maxFreq + k
            // then only when have larger maxFreq, it is possible to have a longer sequence
            // so we don't need to worry about the update when the sequence is acutually invalid
            if (right - left + 1 - curMaxFreq > k) {
                int leftIndex = s.charAt(left++) - 'A';
                freq[leftIndex]--;
                longest = Math.max(longest, curMaxFreq + k);
            }
        }

        // not consider in the loop
        longest = Math.max(longest, right - left);
        return longest;
    }

}