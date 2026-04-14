class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())    return false;

        String conS = s + s;
        int[] lps = new int[goal.length()];
        int i = 0;

        for (int j = 1; j < goal.length(); j++) {
            if (goal.charAt(j) == goal.charAt(i)) {
                lps[j] = ++i;
            } else if (i != 0) {
                i = lps[i - 1];
                j--;
            }
        }

        i = 0;
        for (int j = 0; j < conS.length(); j++) {
            if (goal.charAt(i) == conS.charAt(j)) {
                i++;
                if (i == goal.length()) return true;
            } else if (i != 0) {
                i = lps[i - 1];
                j--;
            }
        }
        return false;
    }
}