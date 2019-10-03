package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 将有序数组转换为二叉搜索树
 * <p>
 * Created by jalr on 2019/9/28.
 */
class leetcode_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            TreeNode root = new TreeNode(nums[l]);
            return root;
        } else {
            int mid = (l + r) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = build(nums, l, mid - 1);
            root.right = build(nums, mid + 1, r);
            return root;
        }
    }
}