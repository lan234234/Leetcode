package binarytree;

/**
 * Given a binary tree in which each node contains an integer number.
 * Find the maximum possible sub path sum
 */
public class MaxPathSumIII_140 {
    public int maxPathSumIII(TreeNode root) {
        // assume root is not null
        // the max is used for updating the max path sum
        int[] max = new int[] {Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }
    // update max and return the max sum of a single path containing the root
    private int helper(TreeNode root, int[] max) {
        // base case:
        if (root == null) {
            return 0;
        }
        // recursive rule:
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        left = left <= 0 ? 0 : left;
        right = right <= 0 ? 0 : right;
        int currentMax = root.key + Math.max(left, right);
        max[0] = Math.max(max[0], currentMax);
        return currentMax;
    }

}
