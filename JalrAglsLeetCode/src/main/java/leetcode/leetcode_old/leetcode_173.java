package leetcode.leetcode_old;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// leetcode.173
class BSTIterator {

    private int pos = 0;
    private ArrayList<TreeNode> res = new ArrayList<>();
    
    public BSTIterator(TreeNode root) {
        // inOrderInit(root);
        inOrderInitNonRecursive(root);
    }

    @SuppressWarnings("all")
    /**
     * 递归版-183 ms, 击败了 5.42% 的用户
     * 
     * @param node
     */
    private void inOrderInit(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderInit(node.left);
        res.add(node);
        inOrderInit(node.right);
    }

    /**
     * 非递归版-144ms, 击败了 44.65% 的用户（怎么还是慢 = =）
     * 
     * @param node
     */
    private void inOrderInitNonRecursive(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        if (current == null) {
            return;
        }
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                res.add(current);
                current = current.right;
            }
        }

    }

    /**
     * @return the next smallest number
     * 
     */
    public int next() {
        return res.get(pos++).val;
    }

    /**
     * @return whether we have a next smallest number
     * 
     */
    public boolean hasNext() {
        return (pos < res.size());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */