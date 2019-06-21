package leetcode.leetcode_CyC;

class Solution26 {

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(nums));
        printArray(nums);
        // System.out.println("111");

    }

    // nums = [0,0,1,1,1,2,2,3,3,4],
    public static int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[p1] == nums[p2]) {
                p2++;
            } else {
                nums[++p1] = nums[p2++];
            }
        }

        return p1 + 1;
    }

    private static void printArray(int[] nums) {
        for (int var : nums) {
            System.out.print(var + "   ");
        }
    }
}