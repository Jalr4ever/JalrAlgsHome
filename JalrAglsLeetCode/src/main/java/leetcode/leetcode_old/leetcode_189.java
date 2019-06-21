package leetcode.leetcode_old;

class Solution189 {
    public static void main(String[] args) {
        int[] a = { 1, 2 };
        new Solution189().rotate(a, 3);
        new Solution189().printArray(a);
    }

    /**
     * 
     * leetcode-189
     * 
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        if (nums == null || k == 0 || nums.length == 1) {
            return;
        }

        k = k % nums.length; // 真正的移动位数

        int[] temp = new int[k];

        int offset = nums.length - k;
        int offset_pos = 0;

        for (int i = offset; i < nums.length; i++) {
            temp[offset_pos++] = nums[i];
        }

        for (int i = offset - 1; i >= 0; i--) { // 往后挪动
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }

    }

    public void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "   ");
        }
    }
}