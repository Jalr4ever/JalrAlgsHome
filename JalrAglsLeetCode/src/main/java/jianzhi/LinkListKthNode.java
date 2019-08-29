package main.java.jianzhi;

/**
 * @program: JalrAlgsBin
 * @description: 剑指 - 链表倒数第 N 个节点
 * <p>
 * Created by jalr on 2019/8/25.
 */

import java.util.*;

public class LinkListKthNode {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        return sol2(head, k);
    }

    //第一种方案 ： 栈
    private ListNode sol1(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.size() < k) {
            return null;
        }
        while (k > 1) {
            stack.pop();
            k--;
        }
        return stack.pop();
    }

    //第二种方案： 存下读取
    private ListNode sol2(ListNode head, int k) {
        ListNode p = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        if (list.size() < k) {
            return null;
        }
        return list.get(list.size() - k);
    }
}