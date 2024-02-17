package bfs;

import binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PrintTreeInLevelOrder_566 {
    public List<Integer> printTreeInLevelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // corner case:
        if (root == null) {
            return list;
        }
        // general case:
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.key);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return list;
    }

}
