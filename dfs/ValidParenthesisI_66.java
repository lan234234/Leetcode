package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given N pairs of parentheses “()”, return a list with all the valid permutations.
 */

public class ValidParenthesisI_66 {
    public List<String> permutationOfParenthesis(int n) {
        // assume n >= 0
        List<String> result = new ArrayList<>();
        // array: permutation of parenthesis in current level
        char[] array = new char[2 * n];
        helper(0, array, result, 0, 0);
        return result;
    }
    // in each position in array, determine to fill in it with "(" or ")"
    private void helper(int index, char[] array, List<String> result, int rightCount, int leftCount) {
        // index: the current position in array where we want to fill in
        // index also means the current level
        // leftCount, rightCount: the number of "(" and ")"
        // in current permutation, if number of '(' is smaller than number of ')'  or the number of '(' is larger than half of the array's length , it means the parenthesis is invalid
        if (leftCount < rightCount || leftCount > array.length / 2) {
            return;
        }
        // terminate condition: for each position in the array, we have determined to append "(" or ")", the array is completed
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        // case 1: append '('
        array[index] = '(';
        helper(index + 1, array, result, rightCount, leftCount + 1);
        // case 2: append ')'
        array[index] = ')';
        helper(index + 1, array, result, rightCount + 1, leftCount);
        return;
    }

}
