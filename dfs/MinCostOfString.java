package dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinCostOfString {
    //    method 1: without memo
    public int minCost(String input) {
        // assume input is not null and not empty
        // assume input String only contains '1', '0' and '!'
        int[] min = {Integer.MAX_VALUE};
        dfs(input, input.length() - 1, 0, 0, 0, min);
        return min[0];
    }
    // if the character in current index is !, determine it is '0' or '1', and update min
// num0: # of 0 in the index range of (index, input.length())
// cost: the cost of the characters in the index range of (index, input.length())
    private void dfs(String input, int index, int num0, int num1, int cost,  int[] min) {
        // termination condition:
        if (index == -1) {
            min[0] = Math.min(min[0], cost);
            return;
        }
// current character is not '!'
        if (input.charAt(index) == '0') {
            dfs(input, index - 1, num0 + 1, num1, cost + 2 * num1, min);
        } else if (input.charAt(index) == '1') {
            dfs(input, index - 1, num0, num1 + 1, cost + 3 * num0, min);
        } else {
// current character is '!'
            // case 1: choose '0'
            dfs(input, index - 1, num0 + 1, num1, cost + 2 * num1, min);
            // case 2: choose '1'
            dfs(input, index - 1, num0, num1 + 1, cost + 3 * num0, min);
        }
    }

    // method 2: with memo
    public int minCost2(String input) {
        // assume input is not null and not empty
        // assume input String only contains '1', '0' and '!'
        // key = a list consist of 3 integers; value = cost of characters before current element (include current element)
// list.get(0) is the index of current character, list.get(1) is the # of '0' after current character, list.get(2) is the # of '1' after current character
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(input, input.length() - 1, 0, 0, memo);
    }
    // return the cost of the character in the range of [0, index]
// num0: # of 0 in the index range of (index, input.length())
    private int dfs(String input, int index, int num0, int num1, Map<List<Integer>, Integer> memo) {
        // base case:
        if (index == -1) {
            return 0;
        }
// current character is not '!'
        if (input.charAt(index) == '0') {
            return 2 * num1 + dfs(input, index - 1, num0 + 1, num1, memo);
        } else if (input.charAt(index) == '1') {
            return 3 * num0 + dfs(input, index - 1, num0, num1 + 1, memo);
        } else {
// current character is '!'
            List<Integer> list = Arrays.asList(index, num0, num1);
            if (memo.containsKey(list))	return memo.get(list);
            // case 1: choose '0'
            int cost0 = 2 * num1 + dfs(input, index - 1, num0 + 1, num1, memo);
            // case 2: choose '1'
            int cost1 = 3 * num0 + dfs(input, index - 1, num0, num1 + 1, memo);
            int minCost = Math.min(cost0, cost1);
            memo.put(list, minCost);
            return minCost;
        }
    }


}
