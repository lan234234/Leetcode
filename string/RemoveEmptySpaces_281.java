package string;

public class RemoveEmptySpaces_281 {
    public String removeSpaces(String input) {
        // corner case:
        if (input == null || input.length() == 0) {
            return input;
        }
        // general case:
        char[] array = input.toCharArray();
        int i = 0;
        int j = 0;
        while (j < array.length) {
            if (array[j] == ' ' && (i == 0 || array[i - 1] == ' ')) {
                j++;
            } else {
                array[i++] = array[j++];
            }
        }
        if (i > 0 && array[i - 1] == ' ') {
            i--;
        }
        return new String(array, 0, i);
    }

}
