package binarytree;

public class IsBalancedBinaryTree_46 {
    public boolean isBalancedBinaryTree(TreeNode root) {
        return getHeightAndBalance(root).isBalanced;
    }
    private Pair getHeightAndBalance(TreeNode root) {
        Pair result = new Pair();
        // base case:
        if (root == null) {
            result.isBalanced = true;
            return result;
        }
        // recursive rule:
        Pair leftResult = getHeightAndBalance(root.left);
        Pair rightResult = getHeightAndBalance(root.right);
        // update result only when both subtrees are balanced and
        // the difference between subtrees' depth smaller than 1
        // otherwise it's not balanced, so directly return the default result
        if (leftResult.isBalanced && rightResult.isBalanced && Math.abs(leftResult.height - rightResult.height) <= 1) {
            result.isBalanced = true;
            result.height = Math.max(leftResult.height, rightResult.height) + 1;
        }
        return result;
    }

    class Pair {
        boolean isBalanced;
        int height;
    }
}
//        TC: O(n)
//        SC: O(height)
