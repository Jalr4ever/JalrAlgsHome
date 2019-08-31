package main.java.jianzhi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: JalrAlgsBin
 * @description: 二叉树与双向链表
 * <p>
 * Created by jalr on 2019/8/31.
 */
//[10,7,20,6,8,11,23]
class BiTreeAndDoubleLinkedList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        return convert(pRootOfTree);
    }

    private TreeNode convert(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                queue.offer(cur);
                cur = cur.right;
            }
        }
        for (int i = 0; i < queue.size(); i++) {
            TreeNode left = i == 0 ? null : queue.get(i - 1);
            TreeNode right = i == queue.size() - 1 ? null : queue.get(i + 1);
            queue.get(i).left = left;
            queue.get(i).right = right;
        }
        return queue.get(0);
    }
}