package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrderIterativeTraverse_45 {
    public List<Integer> postOrderIterativeTraverse(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // corner case:
        if (root == null) {
            return list;
        }
        // general case:
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    list.add(stack.pollFirst().key);
                }
            } else if (pre == cur.left) {
                if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    list.add(stack.pollFirst().key);
                }
            } else if (pre == cur.right) {
                list.add(stack.pollFirst().key);
            }
            pre = cur;
        }
        return list;
    }

}
