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
        if (root == null)   return 0;

        int sum = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();

            // check left leave
            TreeNode left = cur.left;
            if (left != null && left.left == null && left.right == null) {
                sum += left.val;
            }

            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (left != null) {
                stack.offerFirst(left);
            }
        }
        return sum;
    }
}