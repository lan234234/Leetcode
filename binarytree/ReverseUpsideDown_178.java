package binarytree;

public class ReverseUpsideDown_178 {
    public TreeNode reverseUpsideDown(TreeNode root) {
        // base case:
        if (root == null || root.left == null) {
            return root;
        }
        // subproblem:
        TreeNode newRoot = reverseUpsideDown(root.left);
        // recursive rule:
        root.left.left = root;
        root.left.right = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
    }
// TC: O(height)
// SC: O(height)

}
