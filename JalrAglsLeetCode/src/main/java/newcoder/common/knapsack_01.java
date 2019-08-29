package main.java.newcoder.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JalrAlgsBin
 * @description: 牛客网 - 01背包
 * <p>
 * Created by jalr on 2019/8/23.
 */
public class knapsack_01 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bf.readLine().split(" ");
        int v = Integer.parseInt(str1[0]);
        int n = Integer.parseInt(str1[1]);

        int[] profit = new int[n + 1];
        int[] weight = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] str2 = bf.readLine().split(" ");
            weight[i] = Integer.parseInt(str2[0]);
            profit[i] = Integer.parseInt(str2[1]);
        }
        System.out.println(knapsack(profit, weight, v, n));
    }

    private static int knapsack(int[] profit, int[] weight, int v, int n) {
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][v + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= v; j++) {
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int curNotChoice = dp[i - 1][j];
                    int curChoice = profit[i] + dp[i - 1][j - weight[i]];
                    dp[i][j] = Math.max(curNotChoice, curChoice);
                }
            }
        }
        return dp[n][v];
    }
}