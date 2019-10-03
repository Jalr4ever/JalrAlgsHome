package main.java.jianzhi;

/**
 * @program: JalrAlgsBin
 * @description: 把数组排成最小的数字
 * <p>
 * Created by jalr on 2019/9/12.
 */

import java.util.*;

public class SortArrayToMinNum {
    private ArrayList<Long> paths = new ArrayList<>();
    private boolean[] visited;

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        if (numbers.length == 1) {
            return String.valueOf(numbers[0]);
        }
        visited = new boolean[numbers.length];
        StringBuilder sb = new StringBuilder();
        dfs(numbers, sb, 0);
        Collections.sort(paths);
        return String.valueOf(paths.get(0));
    }

    private void dfs(int[] nums, StringBuilder sb, int cur) {
        if (cur == nums.length) {
            paths.add(Long.parseLong(sb.toString()));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int before = sb.length();
                sb.append(nums[i]);
                visited[i] = true;
                int after = sb.length();
                dfs(nums, sb, cur + 1);
                //status back
                sb.delete(before, after);
                visited[i] = false;
            }
        }
    }
}