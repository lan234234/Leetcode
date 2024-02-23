package bfs;

import java.util.List;

public class GraphNode {
    int key;
    List<GraphNode> neighbors;
    GraphNode(int key) {
        this.key = key;
    }
}
