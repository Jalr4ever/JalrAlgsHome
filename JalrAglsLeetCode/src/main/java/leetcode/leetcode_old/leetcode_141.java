package leetcode.leetcode_old;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution141 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = null;
        ListNode n2 = n1.next;
        System.out.println(n2);
    }
    
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return true; // 相遇
            }
            p1 = p1.next;
            if (p2.next.next == null) {
                return false;
            } else {
                p2 = p2.next.next;
            }
        }

        return false;
    }
}