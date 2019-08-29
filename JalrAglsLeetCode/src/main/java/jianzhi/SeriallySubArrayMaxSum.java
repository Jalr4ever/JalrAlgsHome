package main.java.jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: JalrAlgsBin
 * @description: 剑指 - 连续子数组的最大和
 * <p>
 * Created by jalr on 2019/8/17.
 */
public class SeriallySubArrayMaxSum {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }
        int cur = 0;
        int curMax = Integer.MIN_VALUE;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++){
                cur += array[j];
                maxHeap.offer(cur);
            }
            curMax = curMax > maxHeap.peek() ? curMax : maxHeap.peek();
            maxHeap.clear();
            cur = 0;
        }
        return curMax;
    }
}
