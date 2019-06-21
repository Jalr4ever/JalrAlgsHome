package leetcode.leetcode_CyC;

import java.util.HashMap;

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity + 1);
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        move(node, false);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            move(node, false);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            move(node, true);
            size++;
        }
        if (size > capacity) {
            map.remove(head.key);
            head = head.next;
            if (head == null)
                tail = null;
            else
                head.pre = null;
            size--;
        }
    }

    private void move(Node node, boolean insert) {
        if (node == head) {
            head = head.next;
            if (head == null)
                tail = null;
        } else if (node == tail) {
            tail = tail.pre;
            tail.next = null;
        } else if (!insert) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }
}