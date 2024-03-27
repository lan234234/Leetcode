package binarytree;

public class TreeNodeLeft_646 {
    class TreeNodeLeft {
        int key;
        TreeNodeLeft left;
        TreeNodeLeft right;
        int numNodesLeft;
    }

    /**
     * Given a binary tree, count the number of nodes in each node’s left subtree,
     * and store it in the numNodesLeft field.
     */
    public void storeNumberOfLeftSubtree(TreeNodeLeft root) {
        helper(root);
    }

    /**
     * update the numNodesLeft field and return the sum of nodes
     */
    private int helper(TreeNodeLeft root) {
        // base case:
        if (root == null) {
            return 0;
        }
        // recursive rule:
        int leftResult = helper(root.left);
        int rightResult = helper(root.right);
        root.numNodesLeft = leftResult;
        return leftResult + rightResult + 1;
    }

}
