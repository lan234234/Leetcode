/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p.val == q.val) return null;

        // p is the smaller one
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        while (root != null) {
            if (root.val >= p.val && root.val <= q.val) return root;
            if (root.val < p.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }
}