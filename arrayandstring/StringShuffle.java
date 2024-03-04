package arrayandstring;

/**
 * A1B2C3 --> ABC123
 */
public class StringShuffle {
    /**
     * method 1: merge sort
     */
    public String stringShuffling(String input) {
        // assume only contains numbers from 0 to 9
        // assume all characters are 'A' to 'Z' or '0' to '9'
        // corner case:
        if (input == null || input.length() <= 1) {
            return input;
        }
        // general case:
        char[] array = input.toCharArray();
        char[] result = sort(array, 0, array.length - 1);
        return new String(result);
    }
    private char[] sort(char[] array, int left, int right) {
        // base case:
        if (right - left == 0) {
            return new char[]{array[left]};
        }
        // recursive rule:
        int mid = left + (right - left) / 2;
        char[] leftPart = sort(array, left, mid);
        char[] rightPart = sort(array, mid + 1, right);
        return merge(leftPart, rightPart);
    }
    private char[] merge(char[] left, char[] right) {
        char[] result = new char[left.length + right.length];
        int i = 0;	// traverse left
        int j = 0;	// traverse right
        int k = 0;	// traverse result
        while (i < left.length && j < right.length) {
            boolean isLeftLetter = left[i] >= 'A';
            boolean isRightLetter = right[j] >= 'A';
            if (isLeftLetter && isRightLetter || (!isLeftLetter && !isRightLetter)) {
                result[k++] = left[i] <= right[j] ? left[i++] : right[j++];
            } else {
                result[k++] = isLeftLetter ? left[i++] : right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }
    // TC: O(nlogn)
    // SC: O(n)

    /**
     * method 2: quick sort
     */

    public String stringShuffling2(String input) {
        // corner case:
        if (input == null || input.length() <= 1) {
            return input;
        }
        // general case:
        char[] array = input.toCharArray();
        // step 1: sort array
        quickSort(array, 0, array.length - 1);
        return new String(array);
    }
    private void quickSort(char[] array, int left, int right) {
        // base case:
        if (right - left <= 0) {
            return;
        }
        // recursive rule:
        int pivotIndex = (int) (Math.random() * (right - left + 1) + left);
        swap(array, pivotIndex, right);
        // [left, i): characters has been processed and should locate before pivot
        // [i, j]: characters waiting for processing
        // (j, right): characters has been processed and should locate after pivot
        int i = left;
        int j = right - 1;
        while (i <= j) {
            // if pivot is a number
            if (array[right] <= '9') {
                if (array[i] >= 'A' || array[i] <= array[right]) {
                    i++;
                } else if (array[j] <= '9' && array[j] > array[right]) {
                    j--;
                } else {
                    swap(array, i++, j--);
                }
            } else {
            // if pivot is a letter
                if (array[i] >= 'A' && array[i] <= array[right]) {
                    i++;
                } else if (array[j] <= '9' || array[j] > array[right]) {
                    j++;
                } else {
                    swap(array, i++, j--);
                }
            }
        }
        swap(array, i, right);
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    // TC: O(nlogn)
    // SC: O(n)

}
