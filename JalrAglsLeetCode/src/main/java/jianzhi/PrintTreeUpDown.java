package main.java.jianzhi;

import java.util.*;

/**
 * @program: JalrAlgsBin
 * @description: 剑指 - 从上往下打印二叉树
 * <p>
 * Created by jalr on 2019/8/17.
 */


public class PrintTreeUpDown {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            result.add(cur.val);
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        return result;
    }
}
