package binarytree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given K nodes in a binary tree, find their lowest common ancestor.
 *
 * Assumptions
 * - K >= 2
 * -There is no parent pointer for the nodes in the binary tree
 * - The given K nodes are guaranteed to be in the binary tree
 */
public class LCAIV_129 {
    public TreeNode LCAIV(TreeNode root, List<TreeNode> nodes) {
        // assume nodes.size() > 0
        // assume not all nodes is the list are null
        // corner case:
        if (root == null) {
            return root;
        }
        Set<TreeNode> set = toSet(nodes);
        return helper(root, set);
    }

    private Set<TreeNode> toSet(List<TreeNode> nodes) {
        Set<TreeNode> set = new HashSet<>();
        for(TreeNode node : nodes) {
            set.add(node);
        }
        return set;
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> set) {
        // base case:
        if (root == null) {
            return null;
        }
        // recursive rule:
        if (set.contains(root)) {
            return root;
        }
        TreeNode leftResult = helper(root.left, set);
        TreeNode rightResult = helper(root.right, set);
        if (leftResult != null && rightResult != null) {
            return root;
        }
        return leftResult != null ? leftResult : rightResult;
    }

}
