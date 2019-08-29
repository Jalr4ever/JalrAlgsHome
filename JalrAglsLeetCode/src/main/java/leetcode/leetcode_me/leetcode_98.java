package main.java.leetcode.leetcode_me;


import java.util.Stack;

/**
 * @program: JalrAlgsBin
 * @description: 判断一棵树是否是二叉排序树
 * <p>
 * Created by jalr on 2019/7/26.
 */
public class leetcode_98 {
    public boolean isValidBST(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (cur.val <= pre) {
                    return false;
                } else {
                    pre = cur.val;
                }
                cur = cur.right;
            }
        }

        return true;
    }
    private boolean isBST = true;
    private TreeNode inOrder(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = inOrder(root.left);
// TODO: 2019/7/26 递归版的二叉搜索树判断
        return null;
    }
}
