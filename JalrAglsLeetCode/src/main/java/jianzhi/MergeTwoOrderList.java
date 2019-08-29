package main.java.jianzhi;

/**
 * @program: JalrAlgsBin
 * @description: 剑指 - 合并两个有序链表
 * <p>
 * Created by jalr on 2019/8/25.
 */
public class MergeTwoOrderList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newList = new ListNode(-1);
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p3 = newList;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }

        while (p1 != null) {
            p3.next = p1;
            p1 = p1.next;
            p3 = p3.next;
        }

        while (p2 != null) {
            p3.next = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        return newList.next;
    }
}
