package main.java.leetcode.leetcode_category_top_ten.dp;

/**
 * @program: JalrAlgsBin
 * @description: 最大子序和
 * <p>
 * Created by jalr on 2019/10/23.
 */

class leetcode_53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}