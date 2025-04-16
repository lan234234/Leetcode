package math;

public class BasicCalculatorII_227 {
    int index;
    public int calculate(String s) {
        index = 0;
        return helper(s);
    }

    private int helper(String s) {
        int res = 0;
        int cur = 0;
        int pre = 0;
        char preSign = '+';

        while (index < s.length() && s.charAt(index) !=')') {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            } else if (c == '(') {
                index++;
                cur = helper(s);
            } else if (c != ' ') {
                if (preSign == '+') {
                    pre = cur;
                    res += cur;
                } else if (preSign == '-') {
                    res -= cur;
                    pre = -cur;
                } else if (preSign == '*') {
                    res = res - pre + pre * cur;
                    pre *= cur;
                } else {
                    res = res - pre + pre / cur;
                    pre /= cur;
                }
                cur = 0;
                preSign = c;
            }
            index++;
        }

        if (preSign == '+') {
            res += cur;
        } else if (preSign == '-') {
            res -= cur;
        } else if (preSign == '*') {
            res = res - pre + pre * cur;
        } else {
            res = res - pre + pre / cur;
        }
        return res;
    }
}
