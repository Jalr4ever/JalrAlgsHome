package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 打家劫舍
 * <p>
 * Created by jalr on 2019/9/15.
 */
class leetcode_198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}