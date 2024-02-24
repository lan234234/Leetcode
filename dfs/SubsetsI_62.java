package dfs;

import java.util.ArrayList;
import java.util.List;

public class SubsetsI_62 {
    public List<String> subsetsI(String input) {
        List<String> result = new ArrayList<>();
        // corner case:
        if (input == null) {
            return result;
        }
        // general case:
        // sb: record the current subset
        StringBuilder sb = new StringBuilder();
        helper(0, input, result, sb);
        return result;
    }
    // at each level, determine if the current character would be appended
    private void helper(int index, String input, List<String> result, StringBuilder sb) {
        // index: index of current visiting character in the String
        // terminate condition: for each character in the string, if we have already made a decision about whether to append it or not, it means we have complete the subset
        if (index == input.length()) {
            result.add(sb.toString());
            return;
        }
        // case 1: not append current visiting character
        helper(index + 1, input, result, sb);
        // case 2: append current visiting character
        sb.append(input.charAt(index));
        helper(index + 1, input, result, sb);
        // delete the added character for back tracking to previous level
        sb.deleteCharAt(sb.length() - 1);
    }

}
