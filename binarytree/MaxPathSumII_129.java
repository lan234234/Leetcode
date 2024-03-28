package binarytree;

public class MaxPathSumII_129 {
    public int maxPathSum(TreeNode root) {
        // assume all sum are in the integer range
        // assume root is not null
        int[] max = new int[]{root.key};
        helper(root, max);
        return max[0];
    }

    // update maxSum and return current max sum of a single path containing the root
    public int helper(TreeNode root, int[] max) {
        if (root == null) return 0;
        int leftResult = helper(root.left, max);
        int rightResult = helper(root.right, max);
        //if leftResult or rightResult < 0, it's no need the inherit
        leftResult = leftResult > 0 ? leftResult : 0;
        rightResult = rightResult > 0 ? rightResult : 0;
        max[0] = Math.max(max[0], leftResult + rightResult + root.key);
        return Math.max(leftResult, rightResult) + root.key;
    }

}
