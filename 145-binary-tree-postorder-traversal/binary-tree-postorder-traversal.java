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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)   return res;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    stack.pollFirst();
                    res.add(cur.val);
                }
            } else if (cur.left == pre) {
                if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    stack.pollFirst();
                    res.add(cur.val);
                }
            } else {
                stack.pollFirst();
                res.add(cur.val);
            }
            pre = cur;
        }
        return res;
    }
}