class Solution {
    int n;
    int count;
    public int countSubstrings(String s) {
        n = s.length();
        if (n == 1) return 1;

        count = 0;
        for (int i = 0; i < n; i++) {
            maxPalindrom(s, i, i);
            maxPalindrom(s, i, i + 1);
        }
        return count;
    }

    private void maxPalindrom(String s, int left, int right) {
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}