package main.java.leetcode.leetcode_me;

import java.util.*;
/**
 * @program: JalrAlgsBin
 * @description: 求二叉树的最大深度
 * <p>
 * Created by jalr on 2019/7/25.
 */

/**
 * 思路一：递归求最大深度
 */
class Solution104Pt2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depthLeft = maxDepth(root.left) + 1;
        int depthRight = maxDepth(root.right) + 1;
        return depthLeft > depthRight ? depthLeft : depthRight;
    }
}


//思路二：非递归求最大深度 - 根本上是层次遍历
class Solution104Pt1 {
    Queue<TreeNode> queue1 = new LinkedList<>();
    Queue<TreeNode> queue2 = new LinkedList<>();

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int res = 0;
        queue1.add(root);
        while (!queue1.isEmpty()) {
            res++;
            while (!queue1.isEmpty()) {
                TreeNode cur = queue1.poll();
                assert cur != null;
                if (cur.left != null) {
                    queue2.add(cur.left);
                }

                if (cur.right != null) {
                    queue2.add(cur.right);
                }
            }
            swap();
        }
        return res;
    }

    private void swap() {
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
}