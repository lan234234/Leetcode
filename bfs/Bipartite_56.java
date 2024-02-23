package bfs;

import java.util.*;

/**
 * Determine if an undirected graph is bipartite.
 * A bipartite graph is one in which the nodes can be divided into
 * two groups such that no nodes have direct edges to other nodes in the same group.
 */

public class Bipartite_56 {
    public boolean isBipartite(List<GraphNode> graph) {
        // assume the graph is not null
        Queue<GraphNode> queue = new ArrayDeque<>();
        // map: the key:value pair in the map is the node:group pair
        Map<GraphNode, Integer> map = new HashMap<>();
        // i: the index of node in the graph that will be visited in the next
        for (int i = 0; !queue.isEmpty() || i < graph.size(); i++) {
            while (!queue.isEmpty()) {
                GraphNode cur = queue.poll();
                // generate all cur's neighbors, and update queue and map
                // during the updating process, if the graph is found to be not isBipartite,
                // return false
                if (!update(cur, queue, map)) {
                    return false;
                }
            }
            if (i < graph.size()) {
                GraphNode node = graph.get(i);
                if (map.containsKey(node)) {
                    continue;
                } else {
                    queue.offer(node);
                    // set the new node's group as 0
                    map.put(node, 0);
                }
            }
        }
        return true;
    }
    private boolean update(GraphNode cur, Queue<GraphNode> queue, Map<GraphNode, Integer> map) {
        Integer curGroup = map.get(cur);
        for (GraphNode neighbor : cur.neighbors) {
            if (map.containsKey(neighbor)) {
                if (map.get(neighbor) == curGroup) {
                    return false;
                }
            } else {
                // the neighbor's group is different with cur
                map.put(neighbor, 1 - curGroup);
                queue.offer(neighbor);
            }
        }
        return true;
    }

}
