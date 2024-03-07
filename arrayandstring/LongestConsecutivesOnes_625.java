package arrayandstring;

public class LongestConsecutivesOnes_625 {
    public int longest(int[] array, int k) {
        // assume array is not null
        // assume array only contains 1 and 0
        // assume k >= 0
        // corner case
        if (array.length <= k) {
            return array.length;
        }
        // general case:
        // [i, j): a subarray only contains 1 after flipping
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int countZero = 0;	// number of 0 in [i, j)
        while (j < array.length) {
            if (array[j] == 1) {
                maxLength = Math.max(maxLength, ++j - i);
            } else if (countZero < k) {
                maxLength = Math.max(maxLength, ++j - i);
                countZero++;
            } else if (array[i++] == 0) {
                countZero--;
            }
        }
        return maxLength;
    }



}
