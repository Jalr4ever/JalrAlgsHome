package leetcode.leetcode_CyC;

class Solution665 {
    public static void main(String[] args) {
        int[] test = { 4, 2, 3 };
        System.out.println(checkPossibility(test));

    }

    /**
     * 一次修改，有两种方案
     *
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        int modify_count = 0;
        for (int i = 0; i < nums.length - 1 && modify_count < 2; i++) {
            if (nums[i + 1] >= nums[i]) {
                continue;
            }
            modify_count++;
            if (i >= 1 && nums[i - 1] > nums[i + 1]) {
                nums[i + 1] = nums[i];
            } else {
                nums[i] = nums[i + 1];
            }
        }

        return modify_count <= 1; // 0 代表没有修改；1 代表修改一次
    }
}