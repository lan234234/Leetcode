package binarytree;

public class CountNodes_563 {
    public int countNodes(TreeNode root) {
        // base case:
        if (root == null) {
            return 0;
        }
        // recursive rule:
        return countNodes(root.right) + countNodes(root.left) + 1;
    }

}
