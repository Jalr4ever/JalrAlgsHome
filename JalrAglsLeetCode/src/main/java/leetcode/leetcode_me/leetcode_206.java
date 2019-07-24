package main.java.leetcode.leetcode_me;

import java.util.Stack;

/**
 * 链表反转
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}

class Solution206 {

    /**
     * 使用头插法
     *
     * @param head
     * @return
     */
    public ListNode reverseListI(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

    /**
     * 使用栈反转
     *
     * @param head
     * @return
     */
    public ListNode reverseListII(ListNode head) {
        if (head == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode res;
        ListNode lastNode;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        res = stack.pop();
        lastNode = res;

        while (!stack.isEmpty()) {
            lastNode.next = stack.pop();
            lastNode = lastNode.next;
        }
        lastNode.next = null;

        return res;
    }
}

class Main {

}
