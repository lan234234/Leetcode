class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())    return "";
        int start = -1;
        int end = -1;
        int[] freq = new int[128];
        int notMatch = t.length();

        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c]--;
            if (freq[c] >= 0)   notMatch--;
            while (notMatch == 0) {
                if (start == -1 || (end - start > right - left)) {
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