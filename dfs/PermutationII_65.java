package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationII_65 {
    public List<String> permutationII(String input) {
        List<String> result = new ArrayList<>();
        // corner case:
        if (input == null) {
            return result;
        }
        // general case:
        char[] array = input.toCharArray();
        helper(array, result, 0);
        return result;
    }
    // determine which character will be fixed in current level
    private void helper(char[] array, List<String> result, int index) {
        // base case:
        if (index == array.length) {
            result.add(new String(array));
        }
        // general case:
        // set: store characters that has been chosen to be fixed in current position
        Set<Character> set = new HashSet();
        // all characters located in or after current index have the possibility to be fixed in current index
        for (int i = index; i < array.length; i++) {
            // if the desired character have not been chosen, swap it with current character and add it to the set
            if (!set.contains(array[i])) {
                set.add(array[i]);
                swap(array, i, index);
                helper(array, result, index + 1);
                // move characters back to original position before backtracking
                swap(array, i, index);
            }
        }
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
