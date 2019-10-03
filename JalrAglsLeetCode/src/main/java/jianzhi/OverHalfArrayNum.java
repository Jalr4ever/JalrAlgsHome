package main.java.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: JalrAlgsBin
 * @description: 数组中超过一半的数字
 * <p>
 * Created by jalr on 2019/9/12.
 */
class OverHalfArrayNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int arr_last = array.length - 1;

        int[] counts = new int[array[arr_last] + 1];

        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }
        int maxCount = 0;
        int res = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                res = i;
            }
        }

        if (maxCount > (array.length / 2)) {
            return res;
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr;
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        pr.offer(1);
        arr = new ArrayList<>(pr);
        System.out.println();
    }
}
