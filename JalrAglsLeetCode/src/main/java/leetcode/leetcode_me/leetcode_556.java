package main.java.leetcode.leetcode_me;

import java.util.Arrays;

/**
 * @program: JalrAlgsBin
 * @description: leetcode 556 详见
 * <p>
 * Created by jalr on 2019/7/23.
 */
public class leetcode_556 {
    public int nextGreaterElement(int n) {
        String S = String.valueOf(n);
        char[] nums = S.toCharArray();
        long res = -1;
        if (nums.length >= 2) {
            for (int i = nums.length - 1; i >= 1; i--) {
                int next = Character.getNumericValue(nums[i]);
                int prev = Character.getNumericValue(nums[i - 1]);
                if (next > prev) {
                    int split = i; // next 对应的 i 是找到分割点，prev 对应 split - 1
                    Arrays.sort(nums, split, nums.length);
                    for (int j = split; j < nums.length; j++) {
                        int cur = Character.getNumericValue(nums[j]);
                        int val = Character.getNumericValue(nums[split - 1]); //要比较的分割节点值
                        if (cur > val) {
                            char temp = nums[j];
                            nums[j] = nums[split - 1];
                            nums[split - 1] = temp;
                            break;
                        }
                    }

                    String newNum = new String(nums);
                    res = Long.parseLong(newNum);
                    res = res > Integer.MAX_VALUE ? -1 : res;
                    break;
                }
            }

        }
        return (int) res;
    }
}
