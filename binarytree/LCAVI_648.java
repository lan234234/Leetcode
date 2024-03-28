package binarytree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCAVI_648 {
    public KnaryTreeNode LCAVI(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
        // assume all nodes in the list are in the tree
        // assume nodes.size() > 0
        // base case:
        if (root == null)	return null;
        // general case:
        Set<KnaryTreeNode> set = toSet(nodes);
        return helper(root, set);
    }

    private KnaryTreeNode helper(KnaryTreeNode root, Set<KnaryTreeNode> set) {
        // base case:
        if (root == null)	return root;
        if (set.contains(root))	return root;
        // recursive rule:
        KnaryTreeNode result = null;
        for (KnaryTreeNode node: root.children) {
            KnaryTreeNode ancestor = helper(node, set);
            if (ancestor != null) {
                if (result != null) return root;
                result = ancestor;
            }
        }
        return result;
    }
    private Set<KnaryTreeNode> toSet(List<KnaryTreeNode> nodes) {
        Set<KnaryTreeNode> set = new HashSet<>();
        for (KnaryTreeNode node : nodes) {
            set.add(node);
        }
        return set;
    }

}
