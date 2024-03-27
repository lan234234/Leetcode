package binarytree;

/**
 * Given two nodes in a binary tree (with parent pointer available),
 * find their lowest common ancestor.
 */
public class LCAII_127 {
    public TreeNodeP lowestCommonAncestorII(TreeNodeP one, TreeNodeP two) {
        // corner case:
        if (one == null || two == null) {
            return null;
        }
        if (one == two) {
            return one;
        }
        // general case:
        // step 1: get one's and two's height
        int oneHeight = getHeight(one);
        int twoHeight = getHeight(two);
        TreeNodeP lower = oneHeight >= twoHeight ? one : two;
        TreeNodeP higher = oneHeight >= twoHeight ? two : one;
        // step 2: find lower's ancestor in the same level as higher
        TreeNodeP lowerAncestor = findAncestor(lower, Math.abs(oneHeight - twoHeight));
        // step 3: find the lowest common ancestor of lowerAncestor and higher
        return helper(lowerAncestor, higher);
    }
    // return the height of node to root
    private int getHeight(TreeNodeP node) {
        int height = 0;
        while (node != null) {
            node = node.parent;
            height++;
        }
        return height;
    }
    // return the ancestor that is diff higher than the node
    private TreeNodeP findAncestor(TreeNodeP node, int diff) {
        while (diff != 0 && node != null) {
            node = node.parent;
            diff--;
        }
        return node;
    }
    // one and two are in the same level, return their lowest common ancestor
    private TreeNodeP helper(TreeNodeP one, TreeNodeP two) {
        while (one != null && two != null && one != two) {
            one = one.parent;
            two = two.parent;
        }
        if (one == null || two == null) {
            return null;
        }
        return one;
    }

}
