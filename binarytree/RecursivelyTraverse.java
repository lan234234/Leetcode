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
        return;
    }

}
