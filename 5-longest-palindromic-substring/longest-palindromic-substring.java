class Solution {
    int n;
    public String longestPalindrome(String s) {
        n = s.length();
        if (n == 1) return s;

        int max = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int[] oddMax = maxPalindrom(s, i, i);
            int[] evenMax = maxPalindrom(s, i, i + 1);
            int[] curMax = oddMax[0] > evenMax[0] ? oddMax : evenMax;

            if (curMax[0] > max) {
                max = curMax[0];
                start = curMax[1];
            }
        }

        return s.substring(start, start + max);
    }

    private int[] maxPalindrom(String s, int left, int right) {
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int len = right - left - 1;
        return new int[]{len, left + 1};
    }
}