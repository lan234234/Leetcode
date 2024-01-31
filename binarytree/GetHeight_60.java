package binarytree;

public class GetHeight_60 {
    /**
     * Find the height of binary tree.
     */
    public int getHeight(TreeNode root) {
        // base case:
        if (root == null) {
            return 0;
        }
        // recursive rule:
        return Math.max(getHeight(root.right), getHeight(root.left));
    }

}
