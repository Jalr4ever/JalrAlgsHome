package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 爬楼梯（斐波那契数列）
 * <p>
 * Created by jalr on 2019/9/15.
 */
class leetcode_70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}