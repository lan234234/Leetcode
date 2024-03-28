package binarytree;

import java.util.ArrayList;
import java.util.List;

public class KnaryTreeNode {
    int key;
    public List<KnaryTreeNode> children;

    public KnaryTreeNode(int key) {
        this.key = key;
        children = new ArrayList<>();
    }
}
