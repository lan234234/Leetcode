package binarytree;

public class LCAI_126 {
  /**
   * Given two nodes in a binary tree, find their lowest common ancestor.
   * Assumptions:
   * - There is no parent pointer for the nodes in the binary tree
   * - The given two nodes are guaranteed to be in the binary tree
   */
  public TreeNode LCAI(TreeNode root, TreeNode one, TreeNode two) {
        // base case:
        if (root == null) {
            return null;
        }
        if (root == one || root == two) {
            return root;
        }
        if (one == two) {
            return one;
        }
        if (one == null || two == null) {
            return one == null ? two : one;
        }
        // recursive rule
        TreeNode leftResult = LCAI(root.left, one, two);
        TreeNode rightResult = LCAI(root.right, one, two);
        if (leftResult != null && rightResult != null) {
            return root;
        }
        return leftResult == null ? rightResult : leftResult;
    }
}
