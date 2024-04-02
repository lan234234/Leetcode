package dp;

/**
 * Given an unsorted array, find the length of the longest subarray
 * in which the numbers are in ascending order.
 */
public class LongestAscendingSubArray_1 {
    public int longestAscendingSubarray(int[] array) {
        // assume the ascending subarray can not have equal element
        // corner case:
        if (array == null) {
            return 0;
        }
        if (array.length <= 1) {
            return array.length;
        }
        // general case:
        int longest = 0;		// store the longest length of subarray with ascending order
        int cur = 0;	// store the length of current subarray with ascending order
        // [0, i): the element has been traversed but not included in current ascending array
        // [i, j): current ascending array
        // [j, array.length): elements waiting for traversing
        int i = 0;
        int j = 0;
        while (j < array.length) {
            if (i == j || array[j] > array[j - 1]) {
                j++;
                cur++;
                longest = Math.max(longest, cur);
            } else {
                i = j;
                cur = 0;
            }
        }
        return longest;
    }

}
