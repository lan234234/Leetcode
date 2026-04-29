/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        if (root == null)   return 0;

        int[] max = helper(root);
        return Math.max(max[0], max[1]);
    }

    // arr[0] is with, arr[1] is without
    private int[] helper(TreeNode root) {
        if (root == null)   return new int[2];

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rob = left[1] + right[1] + root.val;
        return new int[]{rob, notRob};
    }
}