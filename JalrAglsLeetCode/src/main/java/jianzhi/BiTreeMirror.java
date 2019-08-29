package main.java.jianzhi;

/**
 * @program: JalrAlgsBin
 * @description: 二叉树的镜像
 * <p>
 * Created by jalr on 2019/8/1.
 */
public class BiTreeMirror {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
