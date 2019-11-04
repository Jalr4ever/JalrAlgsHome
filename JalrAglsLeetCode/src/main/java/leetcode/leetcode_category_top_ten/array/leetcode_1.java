package main.java.leetcode.leetcode_category_top_ten.array;

/**
 * @program: JalrAlgsBin
 * @description: leetcode_1 - 两数之和
 * <p>
 * Created by jalr on 2019/10/4.
 */
import java.util.HashMap;
import java.util.Map;
class leetcode_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int old = map.getOrDefault(nums[i], -1);
            if (old != -1 && target == nums[old] * 2) {
                return new int[] {old, i};
            }
            map.put(nums[i], i);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            int remain = target - key;
            if (map.containsKey(remain)) {
                return new int[]{val, map.get(remain)};
            }
        }
        return new int[]{};
    }
}
