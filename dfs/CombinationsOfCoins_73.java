package dfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins_73 {
    public List<List<Integer>> combinationsOfCoins(int target, int[] coins) {
        // assume coins' length is larger than 0
        // assume all elements in coins are positive integer
        // assume no duplication in coins
        // assume elements in coins are sorted in descending order
        // assume target is non-negative integer
        // result: store all possible combination of coins
        List<List<Integer>> result = new ArrayList<>();
        // count: store one possible combination, count[index] is the number of coins[index]
        List<Integer> count = new ArrayList<>();
        helper(target, coins, count, result, 0);
        return result;
    }
    // for each level, we will determine how many corresponding coins we will use
    private void helper(int remain, int[] coins, List<Integer> count, List<List<Integer>> result, int index) {
        // remain: the remaining target
        // index: the index of the coin that we need to determine how many we will use
        // terminate condition: For each coin, except the last one, we have determined how many coins will be used. If the last coin can pay the rest, we can get a valid combination. Otherwise, we can not get a valid combination.
        if (index == coins.length - 1) {
            if (remain % coins[index] == 0) {
                count.add(remain / coins[index]);
                result.add(new ArrayList<>(count));
                count.remove(index);
            }
            return;
        }
        // for coins[index], we choose to pick 0, 1, 2... remain/ coins[index] coins
        for (int i = remain / coins[index]; i >= 0; i--) {
            count.add(i);
            helper(remain - i * coins[index], coins, count, result, index + 1);
            // delete the added integer in count for back tracking to previous level
            count.remove(index);
        }
    }

}
