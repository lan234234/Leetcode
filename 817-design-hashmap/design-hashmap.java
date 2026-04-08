class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static final int DEFAULT_CAPACITY = 1000001;
    Node[] arr;
    int size;


    public MyHashMap() {
        arr = new Node[DEFAULT_CAPACITY];
        this.size = 0;
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);
        Node node = arr[index];
        while (node != null) {
            if (node.key == key) {
                node.val = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = arr[index];
        arr[index] = newNode;
    }
    
    public int get(int key) {
        int index = getIndex(key);
        Node node = arr[index];
        while (node != null) {
            if (node.key == key)    return node.val;
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        Node dummy = new Node(-1, -1);
        dummy.next = arr[index];
        Node pre = dummy;
        Node node = arr[index];
        while (node != null) {
            if (node.key == key) {
                pre.next = node.next;
                arr[index] = dummy.next;
            }
            pre = node;
            node = node.next;
        }
    }

    private int getIndex(int key) {
        return key % DEFAULT_CAPACITY;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */