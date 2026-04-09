class Solution {
    // a b a b c
    // 0 0 1 2 
    public boolean rotateString(String s, String goal) {
        if (s == null && goal == null)  return true;
        if (s == null || goal == null || s.length() != goal.length())  return false;
        
        int n = s.length();
        String s2 = s + s;

        int[] lps = new int[n];
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (goal.charAt(i) == goal.charAt(j)) {
                lps[j] = i + 1;
            } else if (i != 0) {
                i = lps[i - 1];
                j--;
            }
        }

        i = 0;
        for (int j = 1; j < 2 * n; j++) {
            if (goal.charAt(i) == s2.charAt(j)) {
                i++;
                if (i == n) return true;
            } else if (i != 0) {
                i = lps[i - 1];
                j--;
            }
        }
        return false;
    }

}