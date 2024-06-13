package dfs;

import java.util.ArrayList;
import java.util.List;

public class SubsetsKI_640 {
    public List<String> subsetsOfSizeK(String input, int k) {
        List<String> result = new ArrayList<>();
        // corner case:
        if (input == null || k < 0) 	return result;
        // general case:
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();	// record current subset
        helper(array, sb, result, k, 0);
        return result;
    }
    // determine whether to append the element in current index to the sb
    private void helper(char[] array, StringBuilder sb, List<String> subsets, int k, int index) {
        // termination condition: when all elements has been determined or sb's length reaches k
        if (sb.length() == k) {
            subsets.add(sb.toString());
            return;
        }
        if (index == array.length) 	return;
        // case 1: choose not to append
        helper(array, sb, subsets, k, index + 1);
        // case 2: choose to append
        sb.append(array[index]);
        helper(array, sb, subsets, k, index + 1);
        // remove the last appended character before backtracking
        sb.deleteCharAt(sb.length() - 1);
    }

}
