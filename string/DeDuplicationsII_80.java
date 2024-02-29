package string;

/**
 * Remove adjacent, repeated characters in a given string,
 * leaving only two characters for each group of such characters.
 * The characters in the string are sorted in ascending order.
 */
public class DeDuplicationsII_80 {
    public String deDuplicationsII(String input) {
        // corner case:
        if (input == null || input.length() <= 1) {
            return input;
        }
        // general case:
        char[] array = input.toCharArray();
        int i = 0;
        int j = 0;
        while (j < array.length) {
            if (i == 0 || array[i - 1] != array[j]) {
                array[i++] = array[j++];
            } else {
                while (j < array.length && array[i - 1] == array[j]) {
                    j++;
                }
                array[i++] = array[j - 1];
            }
        }
        return new String(array, 0, i);
    }

}
