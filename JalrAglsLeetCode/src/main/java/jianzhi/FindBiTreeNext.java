package main.java.jianzhi;

/**
 * @program: JalrAlgsBin
 * @description: 找二叉树的下一个结点
 * <p>
 * Created by jalr on 2019/7/24.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) { //右不为空，根据左根右，那么右的最左就是下一个
            return toLeft(pNode.right);
        } else { //右为空，根据左根右，那么需要找大子树节点为右时，其父节点就是下一个
            while (pNode.next != null) {

                if (pNode == pNode.next.left) {
                    return pNode.next;
                }

                pNode = pNode.next;
            }
        }
        return null;
    }

    private TreeLinkNode toLeft(TreeLinkNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}