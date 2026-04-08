class Solution {
    // a b a b a
    // 0 0 1 2 3
    // a b a b c
    //
    public int strStr(String haystack, String needle) {
        int[] lps = new int[needle.length()];
        int i = 0;
        for (int j = 1; j < lps.length; j++) {
            if (needle.charAt(i) == needle.charAt(j)) {
                lps[j] = ++i;
            } else if (i != 0) {
                i = lps[i - 1];
                j--;
            }
        }

        i = 0;
        for (int j = 0; j < haystack.length(); j++) {
            if (needle.charAt(i) == haystack.charAt(j)) {
                i++;
                if (i == needle.length())   return j - i + 1;
            } else if (i != 0) {
                i = lps[i - 1];
                j--;
            }
        }
        return -1;
    }
}