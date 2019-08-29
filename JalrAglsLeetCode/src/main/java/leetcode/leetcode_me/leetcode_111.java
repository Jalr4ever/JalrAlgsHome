package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 二叉树的最小深度
 * <p>
 * Created by jalr on 2019/7/25.
 */
public class leetcode_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int mL = minDepth(root.left);
        int mR = minDepth(root.right);
        return (root.left == null || root.right == null) ? mL + mR + 1 : Math.min(mL, mR) + 1;
    }
}
