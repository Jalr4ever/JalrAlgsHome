package jianzhi;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class SerializeBiTree {
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String res = root.val + "!";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
    }

    TreeNode Deserialize(String str) {
        if(str.equals("#!")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(str));
        head.left = Deserialize(str);
        head.right = Deserialize(str);
        return head;
    }
}