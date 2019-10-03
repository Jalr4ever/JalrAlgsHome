package main.java.leetcode.leetcode_me;

import java.util.List;

/**
 * @program: JalrAlgsBin
 * @description: 120. 三角形最小路径和(数塔问题)
 * <p>
 * Created by jalr on 2019/9/27.
 */
public class leetcode_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < triangle.size(); i++) {
                min = Math.min(triangle.get(0).get(i), min);
            }
            return min;
        }
        for (int i = triangle.size() - 1; i >= 1; i--) {
            List<Integer> l1 = triangle.get(i);
            List<Integer> l2 = triangle.get(i - 1);
            for (int j = 0; j < l2.size(); j++) {
                int cur = l2.get(j);
                int val = Math.min(cur + l1.get(j), cur + l1.get(j + 1));
                l2.set(j, val);
            }
        }
        return triangle.get(0).get(0);
    }
}
