package main.java.leetcode.leetcode_me;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: JalrAlgsBin
 * @description: 最长定差子序列
 * <p>
 * Created by jalr on 2019/10/8.
 */
class leetcode_5214 {
    public int longestSubsequence(int[] arr, int difference) {
        int cnt = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i : arr) {
            int count = dp.getOrDefault(i - difference, 0) + 1; //dp[i - difference]
            dp.put(i, count);
            cnt = Math.max(count, cnt);
        }
        return cnt;
    }
}