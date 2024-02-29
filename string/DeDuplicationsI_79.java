package string;

public class DeDuplicationsI_79 {
    public String removeRepeatedCharactersI(String input) {
        // corner case:
        if (input == null || input.length() == 0) {
            return input;
        }
        // general case:
        char[] array = input.toCharArray();
        int i = 1;
        int j = 1;
        while (j < array.length) {
            if (array[i - 1] == array[j]) {
                j++;
            } else {
                array[i++] = array[j++];
            }
        }
        return new String(array, 0, i);
    }

}
