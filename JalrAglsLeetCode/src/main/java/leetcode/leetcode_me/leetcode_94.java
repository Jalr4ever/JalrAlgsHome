package main.java.leetcode.leetcode_me;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: JalrAlgsBin
 * @description: 中序遍历二叉树
 * <p>
 * Created by jalr on 2019/7/23.
 */

class leetcode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        inorderRek(root, res);
        inorderNoRek(root, res);
        return res;
    }

    private void inorderRek(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderRek(root.left, list);
        list.add(root.val);
        inorderRek(root.right, list);

    }

    private void inorderNoRek(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
    }
}
