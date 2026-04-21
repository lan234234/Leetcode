class Solution {
    public boolean isNumber(String s) {
        boolean hasDot = false;
        boolean hasE = false;
        boolean hasDigit = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                if (hasE || hasDot) return false;
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (!hasDigit || hasE)  return false;
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