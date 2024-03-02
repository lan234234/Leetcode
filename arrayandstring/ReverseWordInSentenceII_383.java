package arrayandstring;

/**
 * Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.
 */
public class ReverseWordInSentenceII_383 {
    public String reverseWordsInSentenceII(String input) {
        // corner case:
        if (input == null || input.length() == 0) {
            return input;
        }
        // general case:
        char[] array = input.toCharArray();
        // step 1: heading/trailing/duplicate space
        int end = removeSpaces(array);
        // step 2: reverse the whole sentence
        reverse(array, 0, end);
        // step 3: reverse all words
        int start = 0;	// point to the start of the word
        while (start <= end) {
            int wordEnd = start;	// point to the end of the word
            while (wordEnd <= end && array[wordEnd] != ' ') {
                wordEnd++;
            }
            reverse(array, start, wordEnd - 1);
            start = wordEnd + 1;
        }
        return new String(array, 0, end + 1);
    }
    // remove heading/trailing/duplicate spaces in place,
    // return the end index of the last words
    private int removeSpaces(char[] array) {
        // [0, i): the characters should be remained
        // [i, j): the characters has been processed, but we don't care
        // [j, array.length): the characters waiting for processing
        int i = 0;
        int j = 0;
        // step 1: find the first word
        while (j < array.length && array[j] == ' ') {
            j++;
        }
        // step 2: remove duplicate spaces
        while (j < array.length) {
            // find the start of the word
            while (j < array.length && array[j] == ' ') {
                j++;
            }
            // if the first word has been processed, remain a ' ' between two words
            if (i != 0 && j < array.length) {
                array[i++] = ' ';
            }
            // process the word
            while (j < array.length && array[j] != ' ') {
                array[i++] = array[j++];
            }
        }
        return i - 1;
    }
    // reverse the part from start to end
    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }

}
