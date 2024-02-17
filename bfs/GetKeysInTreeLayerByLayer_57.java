package bfs;

import binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Get the list of keys in a given binary tree layer by layer.
 * Each layer is represented by a list of keys and the keys are traversed from left to right.
 */
public class GetKeysInTreeLayerByLayer_57 {
    public List<List<Integer>> getKeysInTreeLayerByLayer(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        // corner case:
        if (root == null) {
            return list;
        }
// general case:
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();	// store key of nodes in current layer
            int size = queue.size();	// size of nodes in current layer
            while (size != 0) {
                TreeNode cur = queue.poll();
                size--;
                curList.add(cur.key);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(curList);
        }
        return list;
    }

}
