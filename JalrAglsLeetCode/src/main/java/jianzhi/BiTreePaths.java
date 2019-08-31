package main.java.jianzhi;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: JalrAlgsBin
 * @description: 剑指 - 二叉树中和为某以值的路径
 * <p>
 * Created by jalr on 2019/8/31.
 */

class BiTreePaths {
    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    private Stack<Integer> path = new Stack();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        find(root, target, 0);
        return paths;
    }

    private void find(TreeNode root, int target, int cur) {
        if (cur == target && root == null) {
            paths.add(new ArrayList(path));

            return;
        }
        if (root == null) {
            return;
        }

        path.push(root.val);
        find(root.left, target, cur + root.val);
        path.pop(); //状态重置

        if (root.left == null && root.right == null) {
            return;
        }

        path.push(root.val);
        find(root.right, target, cur + root.val);
        path.pop(); //状态重置
    }
}
