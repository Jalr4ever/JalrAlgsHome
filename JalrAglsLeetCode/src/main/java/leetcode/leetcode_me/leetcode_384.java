package main.java.leetcode.leetcode_me;

import java.util.Random;

/**
 * @program: JalrAlgsBin
 * @description: 打乱数组 （洗牌算法的应用）
 * <p>
 * Created by jalr on 2019/9/1.
 */

class leetcode_384 {
    private int[] nums;
    private Random r = new Random();

    public leetcode_384(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] res = nums.clone();
        for (int i = res.length - 1; i >= 0; i--) {
            swap(res, i, r.nextInt(i + 1));
        }
        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

