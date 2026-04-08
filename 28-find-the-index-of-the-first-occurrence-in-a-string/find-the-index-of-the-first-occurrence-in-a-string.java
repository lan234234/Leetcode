class Solution {
    /**
    
    Substring,  All Proper Prefixes,    All Suffixes,   Longest Match,  LPS Value
    A,          (None),                 (None),         None,           0
    AB,         A,                      B,              None,           0
    ABA,        A, AB,                  A, BA,          A (len 1),      1
    ABAB,       A,AB,ABA                B,AB,BAB        AB (len 2)      2
    ABABA,      A,AB,ABA,ABAB           A,BA,ABA,BABA   ABA (len 3)     3

    The LPS array tells: "If you fail a match here, don't start over from the beginning."
    Imagine you are matching ABABA against a long text and you fail right after the last A.
    - Because before the last A, the LPS value there is 2, the algorithm knows the last 2 characters you matched (AB) are also the start of your pattern.
    - It keeps those 32 characters "matched" and just checks what comes after the first AB. You effectively "skipped" re-checking those letters.
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n < m)  return -1;

        // 1. construct lps
        int[] lps = new int[m];
        int i = 0;
        int j = 1;
        while (j < m) {
            if (needle.charAt(i) == needle.charAt(j)) {
                lps[j] = ++i;    // lps[j] = ++i; can not be lps[j] = lps[j - 1] + 1;
                j++;
            } else if (i != 0) {
                // utilize lps to find the comparison start point
                i = lps[i - 1];  // can not be lps[j - 1], because the number of overlap is determined by the position i not j
            } else {
                j++;
            }
        }

        // 2. utilize lps to compare
        i = 0;
        j = 0;
        while (j < n && n - j >= m - i) {
            if (needle.charAt(i) == haystack.charAt(j)) {
                i++;
                j++;
                if (i == m) {
                    return j - m;
                }
            } else if (i != 0) {
                i = lps[i - 1];  // can not be lps[j - 1]
            } else {
                j++;
            }
        }
        return -1;
    }
}