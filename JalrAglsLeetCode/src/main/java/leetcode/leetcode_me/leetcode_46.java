package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 全排列
 * <p>
 * Created by jalr on 2019/8/27.
 */

import java.util.*;

class leetcode_46 {
    private Stack<Integer> path = new Stack<>();
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        visited = new boolean[len];
        prem(nums, 0, len);
        return res;
    }

    private void prem(int[] nums, int curSize, int len) {
        if (len == curSize) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;

                prem(nums, curSize + 1, len);

                visited[i] = false;
                path.pop(); //状态重置
            }
        }
    }
}