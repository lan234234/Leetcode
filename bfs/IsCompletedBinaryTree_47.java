package bfs;

import binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsCompletedBinaryTree_47 {
    public boolean isCompletedBinaryTree(TreeNode root) {
        // corner case:
        if (root == null) {
            return true;
        }
// general case:
// queue: store the nodes have been visited but not expanded
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
// meetNull: if a null node has been visited
// if it is true and this is a complete binary tree, we will not meet a non-null child node
        boolean meetNull = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // set meetNull as true when meet null
            if (cur.left == null) {
                meetNull = true;
            } else if (meetNull) {
                // if we have met null but cur.left is not null,
                // it means the binary tree is not completed
                return false;
            } else {
                // if null has not been not met, offer cur.left to queue
                queue.offer(cur.left);
            }
            // the cur.right part has the same logic as the cur.left part above
            if (cur.right == null) {
                meetNull = true;
            } else if (meetNull) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }

}
