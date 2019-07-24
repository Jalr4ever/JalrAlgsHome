package leetcode.leetcode_me;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// l1 l2 不为空
class Solution {

    private static boolean lastHasReamain = false;
    private static ListNode head = new ListNode(-1);
    private static ListNode tail = head;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        while (l1 != null && l2 != null) {
            ListNode node = createSumNode(l1, l2);
            insertNodeToTail(node);
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode node = adjustCurrentNode(l1);
            insertNodeToTail(node);
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode node = adjustCurrentNode(l2);
            insertNodeToTail(node);
            l2 = l2.next;
        }

        if (lastHasReamain) {
            ListNode last = new ListNode(1);
            insertNodeToTail(last);
            lastHasReamain = false;
        }

        ListNode res = head.next; // 矫正
        head = new ListNode(-1); // 迎合 leetcode 的测试，需要指定方法区新的地址
        tail = head;
        return res;
    }

    private static ListNode adjustCurrentNode(ListNode l) {
        int val = l.val;
        val = lastHasReamain ? val + 1 : val;
        lastHasReamain = false;

        if (val >= 10) {
            val = val - 10;
            lastHasReamain = true;
        }

        ListNode node = new ListNode(val);
        return node;
    }

    private static ListNode createSumNode(ListNode l1, ListNode l2) {

        int val = l1.val + l2.val;
        val = lastHasReamain ? val + 1 : val;
        lastHasReamain = false; // 用完归零

        if (val >= 10) {
            val = val - 10;
            lastHasReamain = true;
        }

        ListNode node = new ListNode(val);

        return node;
    }

    private static void insertNodeToTail(ListNode target) {
        tail.next = target;
        tail = target;
    }

}