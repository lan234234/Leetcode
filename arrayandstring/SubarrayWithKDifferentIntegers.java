package arrayandstring;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class SubarrayWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] counts = new int[n + 1];  // count of number in [firstLastIndex, right]
        int firstLastIndex = 0;
        int count = 0;  // count of distinct number in [left, right]
        int res = 0;

        int left = 0;
        for (int right = 0; right < n; right++) {
            int num = nums[right];
            if (counts[num] == 0) {
                count++;
            }
            counts[num]++;
            while (count > k) {
                // in pre loop, count must == k, so nums[firstLastIndex] must be the only one
                counts[nums[firstLastIndex++]] = 0;
                left = firstLastIndex;
                count--;
            }

            if (count == k) {
                num = nums[firstLastIndex];
                while (counts[num] > 1) {
                    firstLastIndex++;
                    counts[num]--;
                    num = nums[firstLastIndex];
                }
                res += firstLastIndex - left + 1;
            }
        }
        return res;
    }
}
