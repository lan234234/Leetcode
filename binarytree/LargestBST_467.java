package binarytree;

public class LargestBST_467 {
    public int largestBST(TreeNode root) {
        return largest(root)[2];
    }
    // update the number of nodes in the largest BST and return an array containing the min, max value and largest BST
    private int[] largest(TreeNode root) {
        // result[0] to result[2] stores the min, max value and the number of node in current tree
        // base case:
        if (root == null) {
            return  new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] result = new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        int[] left = largest(root.left);
        int[] right = largest(root.right);
        if (left[1] < root.key && right[0] > root.key) {
            result[0] = root.left == null ? root.key : left[0];
            result[1] = root.right == null ? root.key : right[1];
            result[2] = 1 + left[2] + right[2];
        } else {
            result[2] = Math.max(left[2], right[2]);
        }
        return result;
    }
//    TC: O(n)
//    SC:O(height)

}
