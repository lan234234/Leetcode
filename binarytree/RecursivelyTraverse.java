package binarytree;

import java.util.ArrayList;
import java.util.List;

public class RecursivelyTraverse {
    /**
     * 655. pre-order traverse
     */
    public List<Integer> preOrderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }
    private void preOrderHelper(TreeNode root, List<Integer> result) {
        // base case:
        if (root == null) {
            return;
        }
        // recursive rule:
        result.add(root.key);
        preOrderHelper(root.left, result);
        preOrderHelper(root.right, result);
    }

    /**
     * 654. in-order traverse
     */
    public List<Integer> inOrderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }
    private void inOrderHelper(TreeNode root, List<Integer> result) {
        // base case:
        if (root == null) {
            return;
        }
        // recursive rule:
        inOrderHelper(root.left, result);
        result.add(root.key);
        inOrderHelper(root.right, result);
    }

    /**
     * 656. in-order traverse
     */
    public List<Integer> postOrderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }
    private void postOrderHelper(TreeNode root, List<Integer> result) {
        // base case:
        if (root == null) {
            return;
        }
        // recursive rule:
        postOrderHelper(root.left, result);
        postOrderHelper(root.right, result);
        result.add(root.key);
    }
}
//TC: O(n)
//SC: O(height) (average case: O(logn) worst case: O(n))

