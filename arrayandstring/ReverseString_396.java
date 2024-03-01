package arrayandstring;

public class ReverseString_396 {
    public String reverseString(String input) {
        // corner case:
        if (input == null || input.length() <= 1) {
            return input;
        }
        // general case:
        char[] array = input.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            swap(array, i++, j--);
        }
        return new String(array);
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
