package main.java.jianzhi;

/**
 * @program: JalrAlgsBin
 * @description: 剑指 - 搜索二叉树的后序序列
 * <p>
 * Created by jalr on 2019/8/26.
 */

class BSTPreOrder {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] seq, int start, int end) {
        if (start >= end) {
            return true;
        }
        int val = seq[end];
        int split = start;
        for (; split < end && seq[split] < val; split++) ;
        for (int i = split; i < end; i++) {
            if (seq[i] < val) {
                return false;
            }
        }
        return isBST(seq, start, split - 1) &&
               isBST(seq, split, end - 1);
    }
}
