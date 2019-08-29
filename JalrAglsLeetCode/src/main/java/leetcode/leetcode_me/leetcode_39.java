package main.java.leetcode.leetcode_me;

import java.util.*;

/**
 * @program: JalrAlgsBin
 * @description: 回溯法 - 组合求和
 * <p>
 * Created by jalr on 2019/8/29.
 */

class leetcode_39 {
    private List<List<Integer>> res = new ArrayList<>();
    private Stack<Integer> path = new Stack<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        combite(candidates, 0, target, 0, path);
        return res;
    }

    private void combite(int[] nums, int start, int target, int cur, Stack<Integer> path) {
        if (cur == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (cur > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.push(nums[i]);
            combite(nums, i, target, cur + nums[i], path);
            path.pop(); //回溯后的状态重置
        }
    }
}