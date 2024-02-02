package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Determine if a given binary tree is binary search tree.
 * There should no be duplicate keys in binary search tree.
 */

public class IsBST_54 {
  /**
   * method 1:
   * TC: O(n)
   * SC: O(n)
   */
  public boolean isBST(TreeNode root) {
        // corner case:
        if (root == null) {
            return true;
        }
        // general case:
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for(int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    private void inOrder(TreeNode root, List<Integer> list) {
        // base case:
        if (root == null) {
            return;
        }
        // recursive rule:
        inOrder(root.left, list);
        list.add(root.key);
        inOrder(root.right, list);
    }

  /**
   * method 2:
   * TC: O(n)
   * SC: O(height)
   */
  public boolean isBST2(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBST(TreeNode root, int min, int max) {
        // base case:
        if (root == null) {
            return true;
        }
        // recursive rule:
        if (root.key <= min || root.key >= max) {
            return false;
        }
        return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
    }
  /**
   * method 3:
   * TC: O(n)
   * SC: O(height)
   */
  public boolean isBST3(TreeNode root) {
      // corner case:
      if (root == null) {
          return true;
      }
// general case:
      return getIsBSTMinMax(root).isBST;
  }

    private Helper getIsBSTMinMax(TreeNode root) {
        Helper result = new Helper(false, root.key, root.key);
        // recursive rule:
        if (root.left != null) {
            Helper leftResult = getIsBSTMinMax(root.left);
            if (!leftResult.isBST || root.key <= leftResult.max) {
                return result;
            }
            result.min = leftResult.min;
        }
        if (root.right != null) {
            Helper rightResult = getIsBSTMinMax(root.right);
            if (!rightResult.isBST || root.key >= rightResult.min) {
                return result;
            }
            result.max = rightResult.max;
        }
        result.isBST = true;
        return result;
    }

    class Helper{
        boolean isBST;
        int min;
        int max;
        // constructor
        public Helper(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

}
