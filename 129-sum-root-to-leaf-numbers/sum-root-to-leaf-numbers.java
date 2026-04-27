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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        if (root == null)   return sum;

        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int preSum) {
        preSum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += preSum;
        } else {
            if (root.left != null) {
                helper(root.left, preSum);
            }
            if (root.right != null) {
                helper(root.right, preSum);
            }
        }
    }
}