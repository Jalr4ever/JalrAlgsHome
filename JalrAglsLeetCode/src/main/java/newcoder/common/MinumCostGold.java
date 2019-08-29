package main.java.newcoder.common;

/**
 * @program: JalrAlgsBin
 * @description: 牛客网 - 切分金条的最小花费
 * <p>
 * Created by jalr on 2019/8/12.
 */

import java.util.*;
import java.io.*;

class MinumCostGold {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        PriorityQueue<Long> w = new PriorityQueue<>();
        for (int i = 0; i < str.length; i++) {
            w.offer(Long.parseLong(str[i]));
        }
        long res = 0;
        while (!w.isEmpty()) {
            long v1 = !w.isEmpty() ? w.poll() : -1;
            long v2 = !w.isEmpty() ? w.poll() : -1;
            if (v1 == -1 || v2 == -1) {
                break;
            }
            res += (v1 + v2);
            w.offer(v1 + v2);
        }
        System.out.println(res);
    }
}
