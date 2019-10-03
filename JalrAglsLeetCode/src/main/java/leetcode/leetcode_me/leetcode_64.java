package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 最小路径和
 * <p>
 * Created by jalr on 2019/9/15.
 */
public class leetcode_64 {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cRight = grid[i - 1][j - 1] + dp[i][j - 1];
                int cDown = grid[i - 1][j - 1] + dp[i - 1][j];
                if (i == 1) {
                    dp[i][j] = cRight;
                } else if (j == 1) {
                    dp[i][j] = cDown;
                } else {
                    dp[i][j] = Math.min(cRight, cDown);
                }
            }
        }
        return dp[m][n];
    }
}
