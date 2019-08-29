package main.java.jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: JalrAlgsBin
 * @description: 剑指 - 调整数组将奇数调整到前偶数调整到后
 * <p>
 * Created by jalr on 2019/8/25.
 */
public class AdjustArrayOddEvenNum {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 1){
            return ;
        }

        Queue<Integer> oddQueue = new LinkedList<>();
        Queue<Integer> evenQueue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (isOddNum(array[i])) {
                oddQueue.offer(array[i]);
            } else {
                evenQueue.offer(array[i]);
            }
        }
        int i = 0;
        while (!oddQueue.isEmpty()) {
            array[i++] = oddQueue.poll();
        }
        while (!evenQueue.isEmpty()) {
            array[i++] = evenQueue.poll();
        }
    }
    private static boolean isOddNum(int num) {
        if ((num & 1) == 1) {
            return true;
        }
        return false;
    }
}
