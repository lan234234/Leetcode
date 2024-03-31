package binarytree;

/**
 * Given a binary tree in which each node contains an integer number.
 * Find the maximum possible path sum from a leaf to root.
 */
public class MaxPathSumIV_639 {
    public int maxPathSumLeafToRoot(TreeNode root) {
        //assume root != null
        if (root.left == null && root.right == null) return root.key;
        if (root.left == null || root.right == null) {
            return (root.left == null ? maxPathSumLeafToRoot(root.right) : maxPathSumLeafToRoot(root.left)) + root.key;
        }
        return Math.max(maxPathSumLeafToRoot(root.right), maxPathSumLeafToRoot(root.left)) + root.key;
    }

}
