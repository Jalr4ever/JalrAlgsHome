package main.java.leetcode.leetcode_me;

/**
 * @program: JalrAlgsBin
 * @description: 颜色分类（荷兰国旗问题）
 * <p>
 * Created by jalr on 2019/7/21.
 */

class Solution75 {

    public void sortColorsII(int[] nums) {
        int cur = 0, p0 = 0, p2 = nums.length - 1;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, cur++, p0++);
            } else if (nums[cur] == 2) {
                swap(nums, cur++, p2--);
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

    }

    public void sortColorsI(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count[0]++;
            } else if (nums[i] == 1) {
                count[1]++;
            } else {
                count[2]++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < count[0]) {
                nums[i] = 0;
            } else if (i < count[0] + count[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
