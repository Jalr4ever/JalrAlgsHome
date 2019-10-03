package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 打家劫舍II
 * <p>
 * Created by jalr on 2019/9/15.
 */
//分类讨论
//1. 第 1 个位置选, 最后一个位置不选
//2. 第 1 个位置不选，最后一个位置选
class leetcode_213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int cho1 = robJudge(nums, 1, n - 1); //选情况一
        int cho2 = robJudge(nums, 2, n); //选情况二
        return Math.max(cho1, cho2);
    }

    private int robJudge(int[] nums, int left, int right) {
        int n = right;
        int[] dp = new int[n + 1];
        dp[left] = nums[left - 1];
        for (int i = left + 1; i <= right; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}