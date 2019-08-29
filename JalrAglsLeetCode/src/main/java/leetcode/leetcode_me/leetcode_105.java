package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 从二叉树的前序和后序来构建二叉树
 * <p>
 * Created by jalr on 2019/8/2.
 */
public class leetcode_105 {

    private int pos = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int[] in, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(pre[pos++]);
        int split = search(in, root.val, start, end); // 求结点在中序数组的位置
        if (split == -1) {
            return null;
        }
        root.left = build(pre, in, start, split - 1); // 数组左边为左树区
        root.right = build(pre, in, split + 1, end); // 数组右边为右书区
        return root;
    }

    private int search(int[] in, int val, int start, int end) {
        for (int i = start; i < end; i++) {
            if (in[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
