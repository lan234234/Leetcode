package binarytree;

import java.util.LinkedList;

public class InsertInBST_51 {
    /**
     * method 1: iterative
     */
    public TreeNode insertInBST(TreeNode root, int key) {
        TreeNode newNode = new TreeNode(key);
        if (root == null) {
            return newNode;
        }
        TreeNode cur = root;
        while (cur.key != key) {
            if (cur.key > key) {
                if (cur.left == null) {
                    cur.left = newNode;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = newNode;
                }
                cur = cur.right;
            }
        }
        return root;
    }
    /**
     * method 2: recursion
     */
    public TreeNode insertInBST2(TreeNode root, int key) {
        // base case:
        if (root == null) {
            return new TreeNode(key);
        }
        // recursive rule:
        if (root.key > key) {
            root.left = insertInBST(root.left, key);
        } else if (root.key < key) {
            root.right = insertInBST(root.right, key);
        }
        return root;
    }

}
