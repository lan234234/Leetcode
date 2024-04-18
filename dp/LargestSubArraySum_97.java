package dp;

/**
 * Given an integer array, find the subarray that has the greatest sum.
 */
public class LargestSubArraySum_97 {

    /**
     * @return the sum
     */
    public int maxSumSubArray(int[] array) {
        // assume array is null or empty
        // assume array is unsorted
        int max = array[0];	// store the result
        int preMaxSum = array[0];	// store the max sum of subarray that include and end with the element that is before the current visiting element
        for (int i = 1; i < array.length; i++) {
            preMaxSum = preMaxSum > 0 ? preMaxSum + array[i] : array[i];
            max = Math.max(preMaxSum, max);
        }
        return max;
    }

    /**
     * @return the border ot the max sum
     */
    public int[] maxSumSubArray2(int[] array) {
        // assume array is null or empty
        // assume array is unsorted
        // result[0] is the left border, result[1] is the right border
        int[] result = new int[2];
        int max = array[0];	// store the max sum of subarray
        int preMaxSum = array[0];	// store the max sum of subarray that include and end with the element that is before the current visiting element
        for (int i = 1; i < array.length; i++) {
            if (preMaxSum > 0) {
                preMaxSum = preMaxSum + array[i];
                if (max < preMaxSum) {
                    max = preMaxSum;
                    result[1] = i;
                }
            } else {
                preMaxSum = array[i];
                if (max < preMaxSum) {
                    max = preMaxSum;
                    result[1] = i;
                    result[0] = i;
                }
            }
        }
        return result;
    }

}
