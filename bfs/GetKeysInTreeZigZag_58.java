package bfs;

import binarytree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GetKeysInTreeZigZag_58 {
    public List<Integer> getKeysInTreeZigZag(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // corner case:
        if (root == null) {
            return list;
        }
        // general case:
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        int level = 1;	// current visiting level
        while (!deque.isEmpty()) {
            // size of nodes in current level
            int size = deque.size();
            while (size != 0) {
                if (level % 2 == 1) {
                    TreeNode cur = deque.pollFirst();
                    list.add(cur.key);
                    // offer right before left
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                } else {
                    TreeNode cur = deque.pollLast();
                    list.add(cur.key);
                    // offer left before right
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                }
                // one node has been polled
                size--;
            }
            // begin to visit the next level
            level++;
        }
        return list;
    }

}
