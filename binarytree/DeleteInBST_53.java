package binarytree;

/**
 * 
 */

public class DeleteInBST_53 {
    public TreeNode deleteInBST(TreeNode root, int key) {
        // base case:
        if (root == null) {
            return root;
        }
        // recursive rule:
        if (root.key > key) {
            root.left = deleteInBST(root.left, key);
        } else if (root.key < key) {
            root.right = deleteInBST(root.right, key);
        } else {
            // case 1: no child
            // case 2: only one child
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }
            // case 3: two child
            // case 3.1 if root.right only have right subtree
            if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            }
            // case 3.2 if root.right have two child
            TreeNode smallest = helper(root.right);
            smallest.right = root.right;
            smallest.left = root.left;
            return smallest;
        }
        return root;
    }
    private TreeNode helper(TreeNode root) {
        TreeNode pre = root;
        TreeNode cur = root.left;
        while (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }
        pre.left = cur.right;
        return cur;
    }
}
