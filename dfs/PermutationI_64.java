package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string with no duplicate characters,
 * return a list with all permutations of the characters.
 */
public class PermutationI_64 {
    public List<String> permutationI(String input) {
        // assume no duplicate character in the input String
        // result: store all possible permutations
        List<String> result = new ArrayList<>();
        char[] array = input.toCharArray();
        helper(array, result, 0);
        return result;
    }

    // in each index, we will choose a character to be fixed in
    private void helper(char[] array, List<String> result, int index) {
        // index: the current position in the array where we need to choose a character to fix
        // terminate condition: if we have determined all characters in the array, the permutation has been completed
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        // the character in the current index can be array[index], array[index + 1] ... array[array.length - 1]
        for (int i = index; i < array.length; i++) {
            // swap the character in current index with the desired one
            swap(array, i, index);
            helper(array, result, index + 1);
            // move the desired character and the original character back to previous position for backtracking to previous level
            swap(array, i, index);
        }
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
