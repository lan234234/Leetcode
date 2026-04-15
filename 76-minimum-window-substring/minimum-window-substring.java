class Solution {
    /**
    input                   output
    String s    String t    String minimum window substring
    "a"         "a"         "a"
    "a"         "aa"        ""
    "aa"        "a"         "a"
    "aba"       "ab"        "ab"/"ba"
    "abc"       "ac"        "abc"
    
    assume neither s nor t is null
    assume neither s nor t is empty
    
    solution: sliding window
    1. t -> char freq array
    2. s = "ADOBECODEBANC", t = "ABC"
                  

     */
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n)  return "";

        int[] freq = new int[128];
        int notMatch = n;
        int left = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < n; i++) {
            freq[t.charAt(i)]++;
        }

        for (int right = 0; right < m; right++) {
            char c = s.charAt(right);
            freq[c]--;
            if (freq[c] >= 0)   notMatch--;
            while (notMatch == 0) {
                if (start == -1 || end - start > right - left) {
                    start = left;
                    end = right;
                }
                c = s.charAt(left++);
                freq[c]++;
                if (freq[c] == 1)   notMatch++;
            }
        }

        return start == -1 ? "" : s.substring(start, end + 1);
    }
}