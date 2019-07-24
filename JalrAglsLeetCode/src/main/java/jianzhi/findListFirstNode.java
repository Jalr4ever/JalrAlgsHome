package main.java.jianzhi;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: JalrAlgsBin
 * @description: 两个链表的第一个公共节点
 * <p>
 * Created by jalr on 2019/7/22.
 */

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class findListFirstNode {
    public ListNode FindFirstCommonNodeII(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (pHead1 != null) {
            hashSet.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            if (hashSet.contains(pHead2)) {
                break;
            }
            pHead2 = pHead2.next;
        }

        return pHead2;
    }

    public ListNode FindFirstCommonNodeI(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
}
