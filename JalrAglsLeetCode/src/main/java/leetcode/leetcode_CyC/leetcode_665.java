package leetcode.leetcode_CyC;

class Solution665 {
    public static void main(String[] args) {
        int[] test = { 4, 2, 3 };

    }

    /**
     * 笨方法 - 分类修改统计
     * 
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int last_num = nums[0];
        boolean isChange = false;
        boolean isMinus = false; // 后一个减掉前一个是否为负
        for (int i = 0; i < nums.length && !isChange; i++) {

            if (nums[i] < last_num) {
                isChange = true;
                int temp = nums[i];
                nums[i] = last_num;
                boolean judge1 = classifyJundge(nums);
                if (judge1 == false) {
                    isMinus = judge1;
                    break;
                }

                nums[i] = temp;
                nums[i - 1] = temp;
                boolean judge2 = classifyJundge(nums);
                isMinus = judge1 && judge2;
                break;
            }

            last_num = nums[i];
        }

        return !isMinus;
    }

    /**
     * 好方法 - 分类修改，统计次数
     * 
     * @param nums
     * @return
     */
    private boolean classifyJundge(int[] nums) {

        boolean isMinus = false;
        int last_num = nums[0];
        for (int i = 0; i < nums.length && !isMinus; i++) {
            isMinus = nums[i] - last_num < 0 ? true : false;
            last_num = nums[i];
        }

        return isMinus;
    }

    public static boolean checkPossibilityII(int[] nums) {
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