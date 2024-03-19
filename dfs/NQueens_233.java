package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Get all valid ways of putting N Queens on an N * N chessboard
 * so that no two Queens threaten each other.
 */
public class NQueens_233 {
    public List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        // location: stores the way to arrange queens.
        // The ith queen is located at row of i - 1 and column of location[i - 1]
        List<Integer> location = new ArrayList<>();
        helper(result, location, n);
        return result;
    }

    // in each index, we will determine the column location of the (index - 1)th queen
    private void helper(List<List<Integer>> result, List<Integer> location, int n) {
        // terminal condition
        if (location.size() == n) {
            result.add(new ArrayList<>(location));
            return;
        }

        // traverse all column position and choose a valid one
        for (int i = 0; i < n; i++) {
            if (valid(i, location)) {
                location.add(i);
                helper(result, location, n);
                // remove the last element before backtracking
                location.remove(location.size() - 1);
            }
        }
    }

    // check if the queen's position is valid
    private boolean valid(int column, List<Integer> location) {
        for (int i = 0; i < location.size(); i++) {
            if (column == location.get(i) || Math.abs(location.size() - i) == Math.abs(column - location.get(i))) {
                return false;
            }
        }
        return true;
    }

    // TC: O(n! * n)
    // SC: O(n)

}
