package main.java.jianzhi;


import java.util.Stack;

/**
 * @program: JalrAlgsBin
 * @description: 剑指 -反转链表
 * <p>
 * Created by jalr on 2019/8/25.
 */
public class ReverseList {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return sol1(head);
    }

    private ListNode sol1(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

    public static ListNode sol2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode p = stack.pop();
        head = p;
        while (!stack.isEmpty()) {
            if (stack.size() == 1) {
                stack.peek().next = null;
            }
            p.next = stack.pop();
            p = p.next;
        }
        return head;
    }
}
