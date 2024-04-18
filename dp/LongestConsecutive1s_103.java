package dp;

/**
 * Given an array containing only 0s and 1s,
 * find the length of the longest subarray of consecutive 1s.
 */
public class LongestConsecutive1s_103 {
    public int longestConsecutive1s(int[] array) {
        // assume array only contains 0s and 1s
        if (array == null || array.length == 0) {
            return 0;
        }
        // represents the length of consecutive 1s of the subarray that end with the element before current visiting element
        int pre = 0;
        // records the longest subarray of consecutive 1s
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                pre = 0;
            } else {
                pre++;
                result = Math.max(pre, result);
            }
        }
        return result;
    }

}
