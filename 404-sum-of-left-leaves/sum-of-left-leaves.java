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
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null) {
                    sum += cur.left.val;
                }

                // find rightMost node in root.left
                TreeNode rightMost = findRightMost(cur.left, cur);

                // if there is a cycle, move to right
                if (rightMost.right != null) {
                    rightMost.right = null; // recover the tree
                    cur = cur.right;
                } else {
                    rightMost.right = cur;
                    cur = cur.left;
                }
            } else {
                cur = cur.right;
            }
        }
        return sum;
    }

    private TreeNode findRightMost(TreeNode root, TreeNode startNode) {
        while (root.right != null && root.right != startNode) {
            root = root.right;
        }
        return root;
    }
}