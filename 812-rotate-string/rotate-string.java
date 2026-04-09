class Solution {
    public boolean rotateString(String s, String goal) {
        if (s == null && goal == null)  return true;
        if (s == null || goal == null || s.length() != goal.length())  return false;
        
        int n = s.length();
        int start1;
        for (int start2 = 0; start2 < n; start2++) {
            start1 = 0;
            int i = start2;
            while (start1 < n) {
                if (s.charAt(start1) == goal.charAt(i)) {
                    i = (i + 1) % n;
                    start1++;
                } else {
                    break;
                }
                if (start1 == n)    return true;
            }
        }
        return false;
    }

}