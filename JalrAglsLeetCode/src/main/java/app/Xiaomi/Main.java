package main.java.app.Xiaomi;

/**
 * @program: JalrAlgsBin
 * @description: 小米笔试
 * <p>
 * Created by jalr on 2019/9/6.
 */

import java.io.*;
import java.util.*;

class Main {
    static TreeNode  p;
    static boolean r1 = false;
    static boolean r2 = false;
    static HashSet<Integer> set = new HashSet<>();
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode paraent;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String level = bf.readLine();
        String[] nodes = bf.readLine().split(" ");
        String[] target = bf.readLine().split(" ");
        int[] nodesint = new int[nodes.length];
        int[] targetint = new int[target.length];
        for (int i = 0; i < targetint.length; i++) {
            targetint[i] = Integer.parseInt(target[i]);
        }

        for (int i = 0; i < nodes.length; i++) {
            nodesint[i] = Integer.parseInt(nodes[i]);
        }

        TreeNode root = getTree(nodesint);
        System.out.println();
    }

    private static TreeNode getTree(int[] nodes) {
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != -1) {
                queue1.offer(new TreeNode(nodes[i]));
            } else {
                queue1.offer(null);
            }
        }

        TreeNode root = queue1.poll();
        TreeNode cur = null;
        queue2.offer(root);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            cur = queue2.poll();
            if (cur == null) {
                continue;
            }
            cur.left = queue1.poll();
            cur.right = queue1.poll();
            if (cur.left != null) {
                cur.left.paraent = cur;
            }
            if (cur.right != null) {
                cur.right.paraent = cur;
            }
            queue2.offer(cur.left);
            queue2.offer(cur.right);
        }
        return root;
    }

    private static void isRight(TreeNode node) {
        if (node == null) {
            return;
        }
        set.add(node.val);
        isRight(node.left);
        isRight(node.right);
    }

    private static TreeNode getResult(TreeNode node, int val1, int val2) {
        isRight(node);
        if (!set.contains(val1) || !set.contains(val2)) {
            set.clear();
            return getResult(node.paraent,val1,val2);
        }else{
            return node.paraent;
        }
    }
}
