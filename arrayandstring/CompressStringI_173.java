package arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, replace adjacent, repeated characters
 * with the character followed by the number of repeated occurrences.
 * If the character does not have any adjacent, repeated occurrences, it is not changed.
 */
public class CompressStringI_173 {
    public String compressString(String input) {
        // assume all characters in input are 'a' to 'z'
        // corner case
        if (input == null || input.length() <= 1) {
            return input;
        }
        // general case:
        char[] array = input.toCharArray();
        // [0, i): the characters have been processed and should be remained
        // [i, j): characters we do not care
        // [j, input.length()): characters waiting for process
        int i = 0;
        int j = 0;
        while (j < array.length) {
            char cur = array[j];
            int count = 1;
            j++;
            while (j < array.length && array[j] == cur) {
                count++;
                j++;
            }
            array[i++] = cur;
            if (count != 1) {
                List<Character> list = convertCountToList(count);
                for (int k = list.size() - 1; k >= 0 ; k--) {
                    array[i++] = list.get(k);
                }
            }
        }
        return new String(array, 0, i);
    }
    private List<Character> convertCountToList(int count) {
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
