package main.java.jianzhi;

import java.util.*;

/**
 * @program: JalrAlgsBin
 * @description: 序列化二叉树
 * <p>
 * Created by jalr on 2019/7/25.
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
class SolutionSerializeTree {

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }

        String res = root.val + "_";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
    }

    TreeNode Deserialize(String str) {
        String[] temp = str.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < temp.length; i++) {
            queue.add(temp[i]);
        }
        return deSerial(queue);
    }

    private TreeNode deSerial(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deSerial(queue);
        root.right = deSerial(queue);
        return root;
    }
}