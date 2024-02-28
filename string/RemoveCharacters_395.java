package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove given characters in input string,
 * the relative order of other characters should be remained.
 * Return the new string after deletion.
 */
public class RemoveCharacters_395 {
    public String removeCharacters(String input, String t) {
        // assume no duplicates in t
        // corner case:
        if (input == null || input.length() == 0 || t == null || t.length() == 0) {
            return input;
        }
        // general case:
        char[] array = input.toCharArray();
        // [0, i): the characters should be remained
        // [i, j): the area we have processed but we do not care about
        // [j, array.length - 1]: the characters waiting for processing
        int i = 0;
        int j = 0;
        // add all distinct characters in t to set
        Set<Character> set = stringToSet(t.toCharArray());
        while (j < array.length) {
            if (set.contains(array[j])) {
                j++;
            } else {
                // move array[j] to the valid area
                array[i++] = array[j++];
            }
        }
        return new String(array, 0, i);
    }
    private Set<Character> stringToSet(char[] input) {
        Set<Character> set = new HashSet<>();
        for (char c : input) {
            set.add(c);
        }
        return set;
    }

// TC: O(m + n)
// SC: O(m + n)

}
