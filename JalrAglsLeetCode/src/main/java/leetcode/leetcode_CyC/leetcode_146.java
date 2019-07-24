package leetcode.leetcode_CyC;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
思路1：使用单链表或者双向链表 + HashMap，则有
get(int key): 遍历链表，找得到指定索引的话，话返回其值，并把该索引的节点移动到链表末尾；找不到，就返回 -1
put(int key, int value): 遍历链表，如果有该索引，更新该索引的值；如果没有，则在链表末尾指定索引中插入值，
如果大于链表最大长度，则直接覆盖链表最后一个节点的值

时间复杂度，get() 是从 hashmap 里查的，很快为 O(1) / O(logn)
put() 的时候要特别注意
当缓存里没有元素的时候且没达到最大容量，直接插入，链表时间复杂度O(1)，hashmap 为 O(1) / O(logn)
当缓存里没有元素且达到最大容量，删除链表尾部元素 O(1), 删除 hashmap 的对应元素，为 O(1) / O(logn)

当缓存里有元素，这是最致命的！要从双向链表里查找到该元素 O(n)，从 hashmap 中更新该元素 O(1) / O(logn)

所以，主要造成时间复杂度过大，效率过慢的情况就是双向链表存在该键，从双向链表里查找到该键值，再放到双向链表尾部这一

*/
class LRUCacheII {

    private int capacity;
    Map<Integer, Integer> cache; // cahce 存的是每一组键值对
    LinkedList<Integer> leastRecentUseList; // 最近最久未使用使用链表更新

    public LRUCacheII(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.leastRecentUseList = new LinkedList<>();
    }

    public int get(int key) {

        if (cache.containsKey(key)) {
            leastRecentUseList.remove((Integer) key);
            leastRecentUseList.add(key); // 移动到链表尾部
            return cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            leastRecentUseList.remove((Integer) key);
        } else if (cache.size() == capacity) {
            cache.remove(leastRecentUseList.removeFirst());
        }
        leastRecentUseList.add(key);
        cache.put(key, value);
    }

}

class Test146 {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int n1 = cache.get(1); // 返回 1
        cache.put(3, 3); // 该操作会使得密钥 2 作废
        int n2 = cache.get(2); // 返回 -1 (未找到)
        cache.put(4, 4); // 该操作会使得密钥 1 作废
        int n3 = cache.get(1); // 返回 -1 (未找到)
        int n4 = cache.get(3); // 返回 3
        int n5 = cache.get(4); // 返回 4

        System.out.println(n1 + " " + n2 + " " + n3 + " " + n4 + " " + n5);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */