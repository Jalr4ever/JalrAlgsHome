package main.java.leetcode.leetcode_category_top_ten.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: JalrAlgsBin
 * @description: 三数之和
 * <p>
 * Created by jalr on 2019/10/5.
 */
class leetcode_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { //重复
                continue;
            }
            if (nums[i] > 0) { //不存在和为 0
                break;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int cur = nums[i] + nums[l] + nums[r];
                if (cur == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    // 如果重复 经过两个 while 保证移动到最后一组重复的 l 与 r，保证下一次移动不相等
                    l++;
                    r--;
                } else if (cur < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return list;
    }
}