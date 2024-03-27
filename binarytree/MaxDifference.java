package binarytree;

public class MaxDifference {
    /**
     * find the node with the max difference in the total number of descendents in its left
     * subtree and right subtree.
     */
    public int maxDifference(TreeNode root) {
        int[] maxDifference = new int[1];
        helper(root, maxDifference);
        return maxDifference[0];
    }
    // update maxDifference and return the total number of nodes
    private int helper(TreeNode root, int[] maxDifference) {
        // base case:
        if (root == null) {
            return 0;
        }
        // recursive rule:
        int leftNumber = helper(root.left, maxDifference);
        int rightNumber = helper(root.right, maxDifference);
        int diff = Math.abs(leftNumber - rightNumber);
        if (diff > maxDifference[0]) {
            maxDifference[0] = diff;
        }
        return leftNumber + rightNumber + 1;
    }

}
