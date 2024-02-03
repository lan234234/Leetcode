package binarytree;

public class SearchInBST_52 {
    /**
     * method 1: recursion
     */
    public TreeNode searchInBST(TreeNode root, int target) {
        // base case:
        if (root == null) {
            return null;
        }
        // recursive rule:
        if (root.key == target) {
            return root;
        }
        if (root.key > target) {
            return searchInBST(root.left, target);
        }
        return searchInBST(root.right, target);
    }

    /**
     * method 2: iteration
     */
    public TreeNode searchInBST2(TreeNode root, int target) {
        // corner case:
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.key == target) {
                return root;
            }
            if (root.key > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }


}
