package design;

import java.util.*;

public class LFUCache_460 {
    class Node {
        int key;
        int val;
        int freq;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            freq = 1;
        }
    }

    Map<Integer, Node> map;
    Map<Integer, LinkedHashSet<Node>> freqs;
    int size;
    int leastFreq;

    public LFUCache_460(int capacity) {
        map = new HashMap<>();
        freqs = new HashMap<>();
        size = capacity;
        leastFreq = 1;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)   return -1;

        remove(node);
        node.freq++;
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            node.freq++;
        } else {
            if (size == map.size()) {
                Node remove = freqs.get(leastFreq).iterator().next();
                remove(remove);
                map.remove(remove.key);
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        add(node);
    }

    private void remove(Node node) {
        Set<Node> cur = freqs.get(node.freq);
        cur.remove(node);
        if (node.freq == leastFreq && cur.isEmpty())  leastFreq++;
    }

    private void add(Node node) {
        LinkedHashSet<Node> next = freqs.get(node.freq);
        if (next == null) {
            next = new LinkedHashSet<>();
            freqs.put(node.freq, next);
        }
        next.add(node);
        if (leastFreq > node.freq)  leastFreq = node.freq;
    }
}
