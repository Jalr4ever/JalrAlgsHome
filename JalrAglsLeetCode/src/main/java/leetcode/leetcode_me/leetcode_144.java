package main.java.leetcode.leetcode_me;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: JalrAlgsBin
 * @description: 先序遍历二叉树
 * <p>
 * Created by jalr on 2019/7/23.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

}

public class leetcode_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preTraversNoRek(root, res);
        return res;
    }

    private void preTravers(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preTravers(root.left, list);
        preTravers(root.right, list);
    }

    private void preTraversNoRek(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
}