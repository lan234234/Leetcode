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

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            freq[index]++;
            curMaxFreq = Math.max(curMaxFreq, freq[index]);
            while (right - left + 1 - curMaxFreq > k) {
                int leftIndex = s.charAt(left++) - 'A';
                freq[leftIndex]--;
                if (freq[leftIndex] == curMaxFreq - 1) {
                    curMaxFreq = findMax(freq);
                }
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    private int findMax(int[] freq) {
        int max = 0;
        for(int f : freq) {
            max = Math.max(max, f);
        }
        return max;
    }

}