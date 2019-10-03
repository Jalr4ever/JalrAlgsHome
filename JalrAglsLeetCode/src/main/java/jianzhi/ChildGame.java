package main.java.jianzhi;

import java.util.ArrayList;

/**
 * @program: JalrAlgsBin
 * @description: 剑指 - 孩子们的游戏（约瑟夫环）
 * <p>
 * Created by jalr on 2019/9/15.
 */
public class ChildGame {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = 0;
        while (list.size() > 1) {
            cur = (cur + m - 1) % list.size();
            list.remove(cur);
        }
        return list.get(0);
    }
}