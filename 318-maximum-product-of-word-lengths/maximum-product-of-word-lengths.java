class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            int bit = getBit(words[i]);
            for (int j = i + 1; j < n; j++) {
                int curBit = getBit(words[j]);
                if ((bit & curBit) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private int getBit(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res |= (1 << (s.charAt(i) - 'a'));
        }
        return res;
    }
}