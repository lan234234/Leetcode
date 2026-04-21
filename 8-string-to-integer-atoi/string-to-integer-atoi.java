class Solution {
    public int myAtoi(String s) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        boolean isNeg = false;
        long num = 0;
        int i = 0;

        // skip leading space
        while (i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        if (i == s.length())    return 0;
        
        // check initial sign
        char c = s.charAt(i);
        if (c == '-') {
            isNeg = true;
            i++;
        } else if (c == '+') {
            i++;
        }

        // process number
        while (i < s.length()) {
            c = s.charAt(i);
            if (!Character.isDigit(c))  break;
            num = num * 10 + c - '0';
            if (!isNeg && num >= MAX) return MAX;
            if (isNeg && -num <= MIN) return MIN;
            i++;
        }
        return (int) num * (isNeg ? -1 : 1);
    }
}