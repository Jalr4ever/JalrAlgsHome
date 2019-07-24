package main.java.leetcode.leetcode_me;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: JalrAlgsBin
 * @description: 后序遍历二叉树
 * <p>
 * Created by jalr on 2019/7/23.
 */

public class leetcode_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        postTraverseRek(root, res);
        postTraverseNoRek(root, res);
        return res;
    }

    private void postTraverseRek(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postTraverseRek(root.left, list);
        postTraverseRek(root.right, list);
        list.add(root.val);
    }

    private void postTraverseNoRek(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        TreeNode cur = root;
        stack1.push(cur);
        while (!stack1.isEmpty()) {
            cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null) {
                stack1.push(cur.left);
            }

            if (cur.right != null) {
                stack1.push(cur.right);
            }
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
    }
}
