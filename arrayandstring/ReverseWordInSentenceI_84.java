package arrayandstring;

public class ReverseWordInSentenceI_84 {
    public String reverseWordsInSentenceI(String input) {
        // corner case:
        // assume words in the sentence are separated by single " "
        // assume no leading and trailing " "
        if (input == null || input.length() <= 1) {
            return input;
        }
        // general case:
        char[] array = input.toCharArray();
        // step 1: reverse the whole array
        reverse(array, 0, array.length - 1);
        // step 2: reverse all words
        int start = 0;	// point to the start of a word
        int end = 0;	// point to the next of the end of a word
        while (end < array.length) {
            while (end < array.length && array[end] != ' ') {
                end++;
            }
            reverse(array, start, end - 1);
            start = ++end;
        }
        return new String(array);
    }
    // reverse the substring with index from start to end in the given array
    private void reverse(char[] array, int start, int end) {
        while (end > start) {
            swap(array, start++, end--);
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
