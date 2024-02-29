package string;

/**
 * Remove adjacent, repeated characters in a given string,
 * leaving no character for each group of such characters.
 * The characters in the string are sorted in ascending order.
 */
public class DeDuplicationsIII_81 {
    public String deDuplication(String input) {
        // corner case:
        if (input == null || input.length() == 0) {
            return input;
        }
        // corner case:
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
                i--;
            }
        }
        return new String(array, 0, i);
    }

}
