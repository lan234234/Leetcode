package bfs;

import binarytree.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

public class AreCousins_295 {
    public boolean areCousins(TreeNode root, int a, int b) {
        // corner case:
        if (root == null || a == b || a == root.key || b == root.key) {
            return false;
        }
        // general case:
        // queue: store nodes have been traversed but not been expanded
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // parent[0] is a's parent, parent [1] is b's parent
        Integer[] parent = new Integer[]{null, null};
        while (!queue.isEmpty()) {
            int size = queue.size();	// the size of nodes that have not been expanded in current level
            // traverse nodes by level and update parent
            while (size != 0) {
                TreeNode cur = queue.poll();
                size--;
                if (cur.left != null) {
                    queue.offer(cur.left);
                    helper(cur.key, cur.left.key, a, b, parent);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    helper(cur.key, cur.right.key, a, b, parent);
                }
            }
            // check a's and b's parents
            if (parent[0] != null && parent[1] != null) {
                return parent[0] != parent[1];
            }
            if (parent[0] != null || parent[1] != null) {
                return false;
            }
        }
        // if none of a or b is met in the tree
        return false;
    }
    public void helper(int root, int child, int a, int b, Integer[] parent) {
        if (child == a) {
            parent[0] = root;
        }
        if (child == b) {
            parent[1] = root;
        }
    }

}
