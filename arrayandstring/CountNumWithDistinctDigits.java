package arrayandstring;

import java.util.HashSet;
import java.util.Set;

public class CountNumWithDistinctDigits {
    public int solution(int left, int right) {
        int result = 0;
        Set<Integer> digits;
        for (int digit2 = left / 100; digit2 <= right / 100; digit2++) {
            digits = new HashSet<>();
            digits.add(digit2);
            for (int digit1 = 0; digit1 <= 9; digit1++) {
                int num = digit2 * 10 + digit1;
                if (num < left / 10)	continue;
                if (num > right / 10)	break;
                if (digits.contains(digit1))	continue;
                digits.add(digit1);
                for (int digit0 = 0; digit0 <= 9; digit0++) {
                    int curNum = num * 10 + digit0;
                    if (curNum < left)	continue;
                    if (curNum > right)	break;
                    if (digits.contains(digit0))	continue;
                    result++;
                }
            }
        }
        return result;
    }


}
