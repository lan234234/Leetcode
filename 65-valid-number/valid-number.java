class Solution {
    /**
    1.1
    1.0
    1.e
    
     */
    public boolean isNumber(String s) {
        boolean hasE = false;
        boolean hasDigit = false;
        boolean hasDot = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
                continue;
            } else if (c == '.') {
                if (hasDot || hasE) return false;
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasE || !hasDigit)  return false;
                hasE = true;
                hasDigit = false;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                return false;
            }
        }
        return hasDigit;
    }
}