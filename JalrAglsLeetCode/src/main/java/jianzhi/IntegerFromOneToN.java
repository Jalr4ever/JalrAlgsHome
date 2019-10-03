package main.java.jianzhi;

/**
 * @program: JalrAlgsBin
 * @description: 1 - N 的中 1 出现的次数
 * <p>
 * Created by jalr on 2019/9/12.
 */

public class IntegerFromOneToN {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 1) {
            return n;
        }
        int start = 1;
        StringBuilder sb = new StringBuilder();
        while (start <= n) {
            sb.append(start++);
        }
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}