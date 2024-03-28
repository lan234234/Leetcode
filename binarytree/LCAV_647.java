package binarytree;

/**
 *
 */
public class LCAV_647 {
    public KnaryTreeNode LCAV(KnaryTreeNode root, KnaryTreeNode one, KnaryTreeNode two) {
        // base case:
        if (root == null) {
            return null;
        }
        if (one == two) {
            return one;
        }
        if (root == one || root == two) {
            return root;
        }
        KnaryTreeNode result = null;
        for (KnaryTreeNode node : root.children) {
            KnaryTreeNode ancestor = LCAV(node, one, two);
            if (ancestor == one || ancestor == two) {
                if (result != null) {
                    return root;
                }
                result = ancestor;
            } else if (ancestor != null) {
                return ancestor;
            }
        }
        return result;
    }
}
