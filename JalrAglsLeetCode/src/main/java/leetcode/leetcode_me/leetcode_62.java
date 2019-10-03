package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 不同路径
 * <p>
 * Created by jalr on 2019/9/15.
 */
class leetcode_62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
