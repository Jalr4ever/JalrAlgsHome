package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 判断平衡二叉树
 * <p>
 * Created by jalr on 2019/7/25.
 */
class leetcode_110 {
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

//九月新写的
class leetcode_110_II{
    public boolean isBalanced(TreeNode root) { //对每一个结点判断是否符合要求
        if (root == null) {
            return true;
        }
        boolean result = judge(root);
        return result && isBalanced(root.left) && isBalanced(root.right);
    }

    private boolean judge(TreeNode root) { //判断高度是否平衡
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) < 2;
    }

    private int height(TreeNode root) { //求树的高度
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left) + 1, height(root.right) + 1);
    }
}