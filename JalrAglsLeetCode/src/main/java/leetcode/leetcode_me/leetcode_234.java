package main.java.leetcode.leetcode_me;

import java.util.Stack;

/**
 * @program: JalrAlgsBin
 * @description: 判断链表是否回文
 * <p>
 * Created by jalr on 2019/7/21.
 */

class leetcode_234 {

    /**
     * 判断链表是否回文
     */
    public boolean isPalindrome(ListNode head) {
        boolean result = true;
        ListNode p1 = head; //慢指针
        ListNode p2 = head; //快指针

        //让p1到达中点，p2到达最后一个点
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        //反转后半部分
        ListNode newHalf = new ListNode(-1);
        while (p1 != null) {
            ListNode next = p1.next;
            p1.next = newHalf.next;
            newHalf.next = p1;
            p1 = next;
        }

        //比较是否回文
        ListNode c1 = head;
        ListNode c2 = newHalf.next;
        while (c1 != null && c2 != null) {
            if (c1.val == c2.val) {
                c1 = c1.next;
                c2 = c2.next;
            } else {
                result = false;
                break;
            }
        }

        //将链表后半部分反转回来
        newHalf.next = null;
        while (p2 != null) {
            ListNode next = p2.next;
            p2.next = newHalf.next;
            newHalf.next = p2;
            p2 = next;
        }

        return result;
    }

    public boolean isPalindromeI(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        while (!stack.isEmpty()) {
            if (head.val == stack.pop().val) {
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
