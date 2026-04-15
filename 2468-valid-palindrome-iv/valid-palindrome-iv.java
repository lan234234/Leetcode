class Solution {
    public boolean makePalindrome(String s) {
        if (s.length() <= 1)    return true;
        int change = 0;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (change == 2)    return false;
                change++;
            }
            i++;
            j--;
        }
        return true;
    }
}