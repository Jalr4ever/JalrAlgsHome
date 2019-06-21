package leetcode.leetcode_CyC;

class Solution121 {

    // 贪心
    public int maxProfitII(int[] prices) {

        int profit_max = 0;

        if (prices.length == 1 || prices.length == 0 || prices == null) {
            return profit_max;
        }

        int min_price = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            } else {
                int profit = prices[i] - min_price;
                profit_max = profit > profit_max ? profit : profit_max;
            }
        }

        return profit_max;
    }

    // 蠢方法 - 暴力解 - 超过 17 %
    public int maxProfitI(int[] prices) {
        int res_max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int compare = prices[j] - prices[i];
                res_max = compare > res_max ? compare : res_max;
            }
        }
        return res_max;
    }
}