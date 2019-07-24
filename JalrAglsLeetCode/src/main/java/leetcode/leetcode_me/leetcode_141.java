package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 判断链表成环 - 超 100% 写法
 * <p>
 * Created by jalr on 2019/7/22.
 */
public class leetcode_141 {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p1 != null) {
            p2 = (p2.next == null) ? null : p2.next.next;
            p1 = p1.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
