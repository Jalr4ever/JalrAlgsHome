package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 判断平衡二叉树
 * <p>
 * Created by jalr on 2019/7/25.
 */
public class leetcode_110 {
    private boolean isBalance;

    public boolean isBalanced(TreeNode root) {
        judgeDepth(root);
        return isBalance;
    }

    private int judgeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthL = judgeDepth(root.left) + 1;
        int depthR = judgeDepth(root.right) + 1;
        if (Math.abs(depthL - depthR) > 1){
            isBalance = false;
        }
        return depthL > depthR ? depthL : depthR;
    }
}
