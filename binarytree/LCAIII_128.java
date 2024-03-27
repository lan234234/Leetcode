package binarytree;

/**
 * Given two nodes in a binary tree, find their lowest common ancestor
 * (the given two nodes are not guaranteed to be in the binary tree).
 *
 * Return null If any of the nodes is not in the tree.
 * Assumptions
 * - There is no parent pointer for the nodes in the binary tree
 * - The given two nodes are not guaranteed to be in the binary tree
 */
public class LCAIII_128 {
    public TreeNode  LCAIII(TreeNode root, TreeNode one, TreeNode two) {
        // corner case:
        if (root == null) {
            return null;
        }
        if (one == two) {
            return one;
        }
        if (one == null || two == null) {
            return one == null ? two : one;
        }
        // general case
        TreeNode node = helper(root, one, two);
        if (node != one  && node != two) {
            return node;
        }
        TreeNode anotherNode = node == one ? two : one;
        return helper(root, anotherNode, anotherNode) == null ? null : node;
    }
    private TreeNode helper(TreeNode root, TreeNode one, TreeNode two) {
        // base case:
        if (root == null) {
            return null;
        }
        // general case:
        if (root == one || root == two) {
            return root;
        }
        TreeNode leftResult = helper(root.left, one, two);
        TreeNode rightResult = helper(root.right, one, two);
        if (leftResult != null && rightResult != null) {
            return root;
        }
        return leftResult != null ? leftResult : rightResult;
    }
}
