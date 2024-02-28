package array;

public class DeDuplicationsIV_82 {
    public String deDuplicationsIV(String input) {
        // corner case:
        if (input == null || input.length() == 0) {
            return input;
        }
        // general case:
        char[] array = input.toCharArray();
        // [0, i): characters should be remain
        // [i, j): area has been processed but we do not care about
        // [j, input.length()): waiting for processing
        int i = 0;
        int j = 0;
        while (j < array.length) {
            // if array[j] is a not a duplication
            if (i == 0 || array[j] != array[i - 1]) {
                array[i++] = array[j++];
            } else {
                // move j to right until array[j] is not a duplication
                while (j < array.length && array[j] == array[i - 1]) {
                    j++;
                }
                // array[i] has duplication in the array, so it can not be remained
                i--;
            }
        }
        return new String(array, 0, i);
    }
    // TC: O(n)
    // SC: O(1)

}
