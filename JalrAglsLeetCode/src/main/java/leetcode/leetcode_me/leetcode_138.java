package main.java.leetcode.leetcode_me;


import java.util.HashMap;

/**
 * @program: JalrAlgsBin
 * @description: 复制带有随机指针的链表
 * <p>
 * Created by jalr on 2019/7/22.
 */
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class leetcode_138 {
        public static void main(String[] args) {
            Node n3 = new Node(3, null, null);
            Node n2 = new Node(2, null, null);
            Node n1 = new Node(1, null, null);
            n1.next = n2;
            n1.random = n3;
            n2.next = n3;
            n2.random = n1;
        }

        /**
         * 第二种方法没有通过，待解决！
         * @param head
         * @return
         */
        public Node copyRandomListII(Node head) {
            Node temp = head;

            //复制节点
            while (temp != null) {
                Node node = new Node(temp.val, null, null);
                Node next = temp.next;
                temp.next = node;
                node.next = next;
                temp = next;
            }

            //更新新节点
            //1 1 2 2 3 3
            Node p1 = head;
            Node l = new Node(-1, null, null);
            Node p2 = l;
            while (p1 != null) {
                Node oldNext = p1.next.next;
                Node newNext = (oldNext == null) ? null : oldNext.next;
                Node oldRand = p1.random;
                Node newRand = (oldRand == null) ? null : oldRand.next;
                Node node = new Node(p1.val, newNext, newRand);
                p2.next = node;
                p2 = p2.next;
                p1 = oldNext;
            }

            //还原链表
            p1 = head;
            while (p1 != null) {
                p1.next = p1.next == null ? null : p1.next.next;
                p1 = p1.next;
            }

            return l.next;
        }

        public Node copyRandomListI(Node head) {
            Node temp = head;
            HashMap<Node, Node> map = new HashMap<>();
            while (temp != null) {
                Node node = new Node(temp.val, null, null);
                map.put(temp, node);
                temp = temp.next;
            }
            Node cur = head;
            map.put(null, null);
            while (cur != null) {
                Node newNode = map.get(cur);
                Node newNext = map.get(cur.next);
                Node newRand = map.get(cur.random);
                newNode.next = newNext;
                newNode.random = newRand;
                cur = cur.next;
            }
            return map.get(head);
        }
}
