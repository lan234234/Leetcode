class Solution {
    /**
    k = 3

    AAA
    BBB
    C
    
    
    
    
     */
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
            if (right - left + 1 - curMaxFreq > k) {
                int leftIndex = s.charAt(left++) - 'A';
                freq[leftIndex]--;
                longest = Math.max(longest, right - left + 1);
            }
        }

        longest = Math.max(longest, right - left);
        return longest;
    }

}