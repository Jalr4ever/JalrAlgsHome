package main.java.app;


import com.sun.org.apache.bcel.internal.generic.INEG;
import com.sun.org.apache.bcel.internal.generic.POP;
import com.sun.org.apache.bcel.internal.generic.SWAP;
import javafx.scene.shape.Circle;
import org.w3c.dom.ls.LSInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.*;
import java.util.logging.Level;

/**
 * @program: JalrAlgsBin
 * @description: 算法题的数组模板
 * <p>
 * Created by jalr on 2019/7/21.
 */

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

}

class Solution {
    LinkedList<TreeNode> queue1 = new LinkedList<>();
    LinkedList<TreeNode> queue2 = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeNode cur = root;
        if (cur == null) {
            return res;
        }

        queue1.add(cur);
        while (!queue1.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!queue1.isEmpty()) {
                cur = queue1.pollFirst();
                if (cur.left != null) {
                    queue2.add(cur.left);
                }

                if (cur.right != null) {
                    queue2.add(cur.right);
                }
                temp.add(cur.val);
            }
            res.add(temp);
            swap();
        }
        return res;
    }

    private void swap() {
        LinkedList<TreeNode> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
}

class Got {
    public static void main(String[] args) {

    }

}

