package app;

import java.util.HashMap;

class LRUCache {

    class Node {

        Node prev;
        Node next;
        int val;
        int key;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    private HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("Capacity not allow less or equals to 0.");
        }

        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.size = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        updateNode(key, node.val);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            updateNode(key, value);
        } else {
            insertNode(key, value);
        }
    }

    private void insertNode(int key, int val) {
        Node node = new Node(key, val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        
        size++;
        cache.put(key, node);

        if (size > capacity) {
            cache.remove(head.key);
            head = head.next;
            size--;
        }

    }

    private void removeNode(int key) {

        if (!cache.containsKey(key)) {
            throw new RuntimeException("Error, the key and val does't exist in LRU Cache");
        }

        Node node = cache.get(key);
        if (node == head && head == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = head.next;
        } else if (node == tail) {
            tail = tail.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        cache.remove(key);
        size--;

    }

    private void updateNode(int key, int val) {

        if (!cache.containsKey(key)) {
            throw new RuntimeException("Error, the key and val does't exist in LRU Cache");
        }

        Node node = cache.get(key);
        node.val = val;
        if (node != tail) {
            removeNode(key);
            insertNode(key, val);
        }

    }
}

class Test {
    public static void main(String[] args) {
        /*
         * ["LRUCache","put","put","get","put","put","get"]
         * [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
         */
        LRUCache ca = new LRUCache(2);
        ca.put(2, 1);
        ca.put(2, 2);
        ca.get(2);
        ca.put(1, 1);
        ca.put(4, 1);
        System.out.println(ca.get(2));
    }
}