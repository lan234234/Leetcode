package dp;

import java.util.HashMap;
import java.util.Map;

public class CountStableSegment {
    public int countStableSegments(int[] capability) {
        // prefixSum[i] presents the sum of elements from capability[0] to capability[i]
        int[] prefixSum = new int[capability.length];
        prefixSum[0] = capability[0];
        for (int i = 1; i < capability.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + capability[i];
        }
        // key is the element (before current i - 2), value is the element's index
        // if there are several same elements in capability, the value is the largest index
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        // a valid segment has at least 3 elements
        for (int i = 2; i < capability.length; i++) {
            map.put(capability[i - 2], i - 2);
            Integer index = map.get(capability[i]);
            if (index != null && capability[i] == prefixSum[i - 1] - prefixSum[index]) {
                result++;
            }
        }
        return result;
    }

}
