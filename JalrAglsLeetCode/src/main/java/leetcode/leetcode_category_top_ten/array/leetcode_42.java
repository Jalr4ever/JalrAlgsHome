package main.java.leetcode.leetcode_category_top_ten.array;

/**
 * @program: JalrAlgsBin
 * @description: 接雨水
 * <p>
 * Created by jalr on 2019/10/6.
 */
class leetcode_42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int left = 1; //第一个柱子
        int right = height.length - 2;//最后一个柱子
        int max_l = height[0]; //第一个最大的左柱子
        int max_r = height[height.length - 1];//第一个最大的右柱子
        while (left <= right) {
            if (max_l < max_r) {
                int store = max_l - height[left];
                ans += store > 0 ? store : 0;
                max_l = Math.max(max_l, height[left++]);
            } else {
                int store = max_r - height[right];
                ans += store > 0 ? store : 0;
                max_r = Math.max(max_r, height[right--]);
            }
        }
        return ans;
    }
}