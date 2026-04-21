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
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = new int[1];
        helper(root, sum, false);
        return sum[0];
    }

    private void helper(TreeNode root, int[] sum, boolean isLeftChild) {
        if (root.left == null && root.right == null) {
            if (isLeftChild) {
                sum[0] += root.val;
            }
            return;
        } 
        if (root.left != null) {
            helper(root.left, sum, true);
        }
        if (root.right != null) {
            helper(root.right, sum, false);
        }  
    }
}