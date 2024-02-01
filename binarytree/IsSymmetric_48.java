package binarytree;

/**
 * Check if a given binary tree is symmetric.
 */

public class IsSymmetric_48 {
    public boolean isSymmetric(TreeNode root) {
        // corner case:
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // base case:
        if (left == null && right == null) {
            return true;
        }
        //recursion rule:
        if (left == null || right == null) {
            return false;
        }
        if (left.key != right.key)	 {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
