package binarytree;

/**
 * TreeNode with parent pointer
 */
public class TreeNodeP {
    int key;
    TreeNodeP left;
    TreeNodeP right;
    TreeNodeP parent;
    // constructor:
    public TreeNodeP(int key, TreeNodeP parent) {
        this.key = key;
        this.parent = parent;
    }
}
