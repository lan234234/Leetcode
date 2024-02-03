package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Get the list of keys in a given binary search tree in a given range[min, max] in ascending order,
 * both min and max are inclusive.
 */

public class GetKeysInBSTInGivenRange_55 {
    public List<Integer> getKeysInBSTInGivenRange(TreeNode root, int min, int max) {
        List<Integer> list = new ArrayList<>();
        helper(root, min, max, list);
        return list;
    }

    private void helper(TreeNode root, int min, int max, List<Integer> list) {
        // base case:
        if (root == null) {
            return;
        }
        // recursive rule:
        if (root.key > min) {
            helper(root.left, min, max, list);
        }
        if (root.key >= min && root.key <= max) {
            list.add(root.key);
        }
        if (root.key < max) {
            helper(root.right, min, max, list);
        }
    }
  /**
   * TC: O(n)
   * SC: O(height)
   */
}
