package hashmap;

import java.util.Arrays;

public class MyHashMap<K, V> {
    class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V result = this.value;
            this.value = value;
            return result;
        }
    }

    private int size;
    private Node [] array;
    private float loadFactor;
    final int SCALE_FACTOR = 2;

    // constructor
	public MyHashMap() {
        loadFactor = 0.75f;
        array = new Node[16];
    }
    public MyHashMap(int capacity, float loadFactor) {
        if (capacity <= 0 || loadFactor <= 0) {
            throw new IllegalArgumentException("cap can not be <= 0");
        }
        this.loadFactor = loadFactor;
        array = new Node[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    private int hash(Object key) {
        if (key == null) {
            return 0;
        }
        // guarantee non-negative
        return key.hashCode() & 0X7FFFFFFF;
    }

    private int getIndex(Object key) {
        return hash(key) % array.length;
    }

    private boolean valueEquals(V v1, V v2) {
        return v1 == v2 || (v1 != null && v1.equals(v2));
    }

    private boolean keyEquals(Object k1, Object k2) {
        return k1 == k2 || (k1 != null && k1.equals(k2));
    }

    public boolean containsKey(Object key) {
        int index = getIndex(key);
        Node cur = array[index];
        while (cur != null) {
            if (keyEquals(cur.key, key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean containsValue(V value) {
        if (isEmpty()) {
            return false;
        }
        for (Node cur : array) {
            while (cur != null) {
                if (valueEquals((V) cur.getValue(), value)) {
                    return true;
                }
                cur = cur.next;
            }
        }
        return false;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node cur = array[index];
        while (cur != null) {
            if (keyEquals(cur.key, key)) {
                return (V) cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        Node cur = array[index];
        while (cur != null) {
            if (keyEquals(cur.key, key)) {
                return (V) cur.setValue(value);
            }
            cur = cur.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = array[index];
        array[index] = newNode;
        size++;
        float ratio = (0.0f + size) / array.length;
        if (ratio >= loadFactor) {
            rehashing();
        }
        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node cur = array[index];
        Node dummy = new Node(cur.getKey(), cur.getValue());
        dummy.next = cur;
        Node pre = dummy;
        while (cur != null) {
            if (keyEquals(cur.key, key)) {
                pre.next = cur.next;
                array[index] = dummy.next;
                size--;
                return (V) cur.getValue();
            }
            pre = cur;
            cur = cur.next;
        }
        return null;
    }

    public void rehashing() {
        Node[] preArray = array;
        array = new Node[preArray.length * SCALE_FACTOR];
        for (Node cur : preArray) {
            while (cur != null) {
                Node next = cur.next;
                int index = getIndex(cur.key);
                cur.next = array[index];
                array[index] = cur;
                cur = next;
            }
        }
    }

}
