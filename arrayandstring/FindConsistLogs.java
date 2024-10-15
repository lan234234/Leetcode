package arrayandstring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindConsistLogs {
    public int findConsistentLogs(int[] userEvent) {
        // step 1: count each number
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : userEvent) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        // step 2: find the minCount
        int minCount = Integer.MAX_VALUE;
        for (Integer count: counts.values()) {
            if (count < minCount) {
                minCount = count;
            }
        }
// step 3: find the max length
        Map<Integer, Integer> cur = new HashMap<>();
// the consistent logs consist of elements in the range of [left, right]
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < userEvent.length) {
            Integer count = cur.getOrDefault(userEvent[right], 0) + 1;
            cur.put(userEvent[right], count);
            while (count > minCount) {
                cur.put(userEvent[left], cur.get(userEvent[left]) - 1);
                left++;
                count = cur.get(userEvent[right]);
            }
            if (checkSame(cur.values())) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;

    }

    private boolean checkSame(Collection<Integer> values) {
        int cur = 0;
        for (Integer value: values) {
            if (value != 0) {
                if (cur == 0) {
                    cur = value;
                } else if (cur != value) {
                    return false;
                }
            }
        }
        return true;
    }


}
