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
    public boolean findTarget(TreeNode root, int k) {
        return postOrder(root, new HashSet<>(), k);
    }

    private boolean postOrder(TreeNode root, Set<Integer> set, int target) {
        if (root == null)   return false;
        if (postOrder(root.left, set, target))  return true;;
        if (postOrder(root.right, set, target)) return true;
        int rem = target - root.val;
        if (set.contains(rem))  return true;
        set.add(root.val);
        return false;
    }
}