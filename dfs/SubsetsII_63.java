package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_63 {
    public List<String> subsetsII(String input) {
        List<String> result = new ArrayList<>();
        // corner case:
        if (input == null)	return result;
        // general case:
        StringBuilder sb = new StringBuilder();	// record the current subset
        char[] array = input.toCharArray();
        // sort the character for dedup
        Arrays.sort(array);
        helper(array, sb, result, 0);
        return result;
    }
    // determine whether to append the character in current index to the stringBuilder
    private void helper(char[] array, StringBuilder sb, List<String> subsets, int index) {
        // termination condition: all characters has been determined
        if (index == array.length) {
            subsets.add(sb.toString());
            return;
        }
        // case 1: not append
        int endIndex = index + 1;	// the first index with different character with array[index]
        // skip all characters with same character as array[index]
        while (endIndex < array.length && array[endIndex] == array[index]) {
            endIndex++;
        }
        helper(array, sb, subsets, endIndex);
        // case 2: append
        sb.append(array[index]);
        helper(array, sb, subsets, index + 1);
        // remove the last appended character for backtracking
        sb.deleteCharAt(sb.length() - 1);
    }

//    TC: O(2^n * n)
//    SC: O(n)

}
