class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitMasks = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            bitMasks[i] = toBitMask(words[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bitMasks[i] & bitMasks[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private int toBitMask(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res |= (1 << (c - 'a'));
        }
        return res;
    }
}