package main.java.leetcode.leetcode_category_top_ten.array;

/**
 * @program: JalrAlgsBin
 * @description: 盛最多水的容器
 * <p>
 * Created by jalr on 2019/10/20.
 */
public class leetcode_11 {
    public int maxArea(int[] height) {
        int rain = 0;
        int pleft = 0;
        int pright = height.length - 1;
        while (pleft != pright) {
            int len = pright - pleft;
            int wid = height[pleft] < height[pright] ? height[pleft++] : height[pright--];
            int area = len * wid;
            rain = Math.max(rain, area);
        }
        return rain;
    }
}
