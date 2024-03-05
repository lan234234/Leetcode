package arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, replace adjacent, repeated characters
 * with the character followed by the number of repeated occurrences.
 */
public class CompressStringII_611 {
    public String compressStringII(String input) {
        // corner case:
        if (input == null || input.length() == 0) {
            return input;
        }
        // step 1: iterate over all characters, process the repeated characters and count single characters
        int[] countSingle = new int[1];
        char[] array = input.toCharArray();
        int end = compress(array, countSingle);	// index of the last characters after being processed
        // step 2: calculate new string's length, determine whether we need create a new array
        int newEnd = countSingle[0] + end;	// index of the last characters after single characters have been processed
        char[] result = array;
        if (newEnd >= array.length) {
            result = new char[countSingle[0] + end + 1];
        }
        // step 3: add '1' after all single characters
        processSingle(array, end, result, newEnd);
        return new String(result, 0, newEnd + 1);
    }
    // replace adjacent, repeated characters with the character followed by the number of repeated occurrences. If the character does not have any adjacent, repeated occurrences, it is not changed. Count single characters numbers and return the index of the last element
    private int compress(char[] array, int[] countSingle) {
        // [0, i): the characters have been processed and should be remained
        // [i, j): characters we do not care
        // [j, input.length()): characters waiting for process
        int i = 0;
        int j = 0;
        while (j < array.length) {
            char cur = array[j];
            int count = 1;
            j++;
            while (j < array.length && cur == array[j]) {
                count++;
                j++;
            }
            array[i++] = cur;
            if (count > 1) {
                List<Character> list = countToCharacter(count);
                for (int k = list.size() - 1; k >= 0; k--) {
                    array[i++] = list.get(k);
                }
            } else {
                countSingle[0]++;
            }
        }
        return i - 1;
    }
    // add '1' after all single characters
    private void processSingle(char[] array, int end, char[] result, int newEnd) {
        int i = end;	// traverse array from end to 0
        int j = newEnd;	// traverse result from newEnd to 0
        while (i >= 0) {
            // if array[i] is the single character
            if (i >= 0 && array[i] > '9') {
                result[j--] = '1';
                result[j--] = array[i--];
            } else {
                // if array[i] is a number
                while (i >= 0 && array[i] <= '9') {
                    result[j--] = array[i--];
                }
                result[j--] = array[i--];
            }
        }
    }
    // convert integer count to a list of character in reverse order
    public List<Character> countToCharacter(int count) {
        List<Character> list = new ArrayList<>();
        while (count != 0) {
            int n = count % 10;
            list.add((char) (n + '0'));
            count /= 10;
        }
        return list;
    }
    // TC: O(n)
    // SC: O(n)

}
