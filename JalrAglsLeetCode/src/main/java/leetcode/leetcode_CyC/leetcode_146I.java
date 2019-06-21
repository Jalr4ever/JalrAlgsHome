package leetcode.leetcode_CyC;

import java.util.HashMap;
import java.util.Map;

/*

思路 2：为了解决更新双向链表已存在 key 的时候，要查找到该 key 时间复杂度为 O(n) 过大的问题，
可以在缓存手动实现一个双向链表，并用 hashmap 存下节点
所以！这次 hashmap 中，不！仅！仅！存键值的对应关系，而是存下了键和值和节点的对应关系
也就是除了能查找到键值，还能查找到节点了，而节点又是双向链表，所以知道了一个节点，也方便对节点直接做一些方便的操作
例如，这次，要更新双向链表已存在的 key 的时候，就用 hashmap 查找到该节点，时间复杂度从 O(n) 变为 O(1) / O(logn)，
找到了节点，再从双向链表中删除，插入到链表末尾

总结：节点是双向链表节点，每次插入删除要按照双向链表的方式维护， hashmap 存储键和节点，因为节点包含了值
*/

class LRUCacheNew {

    class Node {

        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    Node head; // 指向节点的双向链表头部
    Node tail; // 指向节点的双向链表尾部
    int listSize;

    private int capacity;

    Map<Integer, Node> cache;

    public LRUCacheNew(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        listSize = 0;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node getNode = cache.get(key);
            removeFromListByKey(key);
            addNodeToList(getNode); // 这两步删除节点再插入到链表尾部
            return cache.get(key).val;
        }

        return -1;
    }

    public void put(int key, int value) {
        // System.err.println("size: "+ listSize);
        if (cache.containsKey(key)) {
            removeFromListByKey(key);
        } else if (listSize == capacity) {
            Node tempNode = removeListFirstNode();
            removeFromCacheByKey(tempNode.key);
        }

        Node n = new Node(key, value);
        addNodeToList(n);
        addNodeToCache(key, n);
    }

    private Node removeListFirstNode() {
        Node current = head;
        if (head.next != null) { // 存在第二个节点
            head.next.prev = null;
        }
        head = head.next;
        listSize--;
        return current;
    }

    private Node removeListLastNode() {
        Node current = tail;
        if (tail.prev != null) { // 前面还有节点
            tail.prev.next = null;
        }
        tail = tail.prev;
        listSize--;
        return current;
    }

    private boolean removeFromListByKey(int key) {
        if (cache.containsKey(key)) {
            Node delNode = cache.get(key);
            if (delNode == head) {// 头节点
                removeListFirstNode();
            } else if (delNode == tail) { // 尾节点
                removeListLastNode();
            } else {
                delNode.prev.next = delNode.next;
                delNode.next.prev = delNode.prev;
                listSize--;
            }

            return true;
        }

        return false;
    }

    private boolean removeFromCacheByKey(int key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            return true;
        }
        return false;
    }

    private void addNodeToList(Node node) {

        if (head == null) { // 第一次插入节点
            node.prev = null;
            node.next = null;
            head = tail = node;
            listSize++;
        } else {
            node.prev = tail;
            node.next = null;
            tail.next = node;
            tail = node;
            listSize++;
        }
    }

    private void addNodeToCache(int key, Node node) {
        cache.put(key, node);
    }

}

class Test146L {
    public static void main(String[] args) {

        // LRUCacheNew cache = new LRUCacheNew(2);
        // cache.put(1, 1);
        // cache.put(2, 2);
        // int n1 = cache.get(1); // 返回 1
        // cache.put(3, 3); // 该操作会使得密钥 2 作废
        // int n2 = cache.get(2); // 返回 -1 (未找到)
        // cache.put(4, 4); // 该操作会使得密钥 1 作废
        // int n3 = cache.get(1); // 返回 -1 (未找到)
        // int n4 = cache.get(3); // 返回 3
        // int n5 = cache.get(4); // 返回 4

        // System.out.println(n1 + " " + n2 + " " + n3 + " " + n4 + " " + n5);

        /*
         * 
         * ["LRUCache","get","put","get","put","put","get","get"]
         * [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
         * 
         */
        LRUCacheNew cache = new LRUCacheNew(2);
        cache.get(2);
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        cache.get(1);
        cache.get(2);

    }
}