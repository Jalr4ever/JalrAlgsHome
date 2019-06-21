package leetcode.leetcode_CyC;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}

class Solution19 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        new Solution19().removeNthFromEnd(n1, 1);
    }

    // 1->2->3->4->5, n = 2
    // 1->2->3->5
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || n == 0) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        int cnt = 0;
        int realPos = 0;

        while (p1 != null) {
            cnt++;
            p1 = p1.next;
        }

        if (cnt == n) {
            return head.next;
        }

        realPos = cnt - n;

        for (int i = 1; i < realPos; i++) {
            p2 = p2.next;
        }
        p2.next = p2.next.next;

        return head;

    }
}