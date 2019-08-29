package main.java.app.DiDi;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @program: JalrAlgsForDiDi
 * @description: Created by jalr on 2019/8/27.
 */

/**
 * 6
 * 3 + 2 + 1 + -4 * -5 + 1
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] nums = bf.readLine().split(" ");
        process(nums, n);
    }

    private static void process(String[] nums, int n) {
        int p1 = 1;
        int p2 = 3;
        Integer[] number = new Integer[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0, j = 0; i < number.length; i++, j += 2) {
            number[i] = Integer.parseInt(nums[j]);
        }
        int index = 0;
        int back = 0;
        while (p1 < nums.length && p2 < nums.length) {

            String oprt1 = nums[p1];
            String oprt2 = nums[p2];
            while (isSameOp(oprt1, oprt2)) {
                minHeap.add(number[index++]);
                oprt2 = nums[p2 + 2];
            }
            while (!minHeap.isEmpty()) {
                nums[back] = String.valueOf(minHeap.poll());
            }
            p1 += 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i] + " ");
        }
        System.out.println(sb.toString());
    }

    private static boolean isSameOp(String op1, String op2) {
        if (op1.equals("+") || op1.equals("-")) {
            return op2.equals("+") || op2.equals("-");
        } else if (op1.equals("*")) {
            return op2.equals("*");
        } else if (op1.equals("/") || op2.equals("/")) {
            return false;
        }
        return false;
    }
}
