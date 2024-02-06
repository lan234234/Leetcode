package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderIterativeTraverse_43 {
    public List<Integer> inOrderIterativeTraverse(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // corner case:
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        // next: the next visited node
        TreeNode next = root.left;
        while (!stack.isEmpty() || next != null) {
            if (next != null) {
                stack.offerFirst(next);
                next = next.left;
            } else {
                TreeNode cur = stack.pollFirst();
                list.add(cur.key);
                next = cur.right;
            }
        }
        return list;
    }

}
