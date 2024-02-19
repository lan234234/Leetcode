package bfs;

import binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree_296 {
    public List<Integer> rightViewOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // corner case:
        if (root == null) {
            return list;
        }
        // general case:
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();	// number of nodes in current level
            while (count != 0) {
                // expand
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
        // if cur is the rightmost node in current level
                if (count == 1) {
                    list.add(cur.key);
                }
                count--;
            }
        }
        return list;
    }

}
