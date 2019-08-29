package main.java.leetcode.leetcode_me;

import java.util.Arrays;

/**
 * @program: JalrAlgsBin
 * @description: 硬币题 - 零钱兑换
 * <p>
 * Created by jalr on 2019/8/24.
 */
public class leetcode_322 {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) { //面值无法凑
                    continue;
                }
                int subProb = dp[i - coin] + 1;
                dp[i] = Math.min(dp[i], subProb);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
