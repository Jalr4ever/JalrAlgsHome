package main.java.jianzhi;

import java.util.Stack;

public class MockStackPopSequence {

    //模拟：弹出序列的压入 或 压入序列的弹出
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null ||
                popA == null ||
                pushA.length == 0 ||
                popA.length == 0 ||
                popA.length != pushA.length) {
            return false;
        }
        return mock(pushA, popA);
    }

    private boolean mock(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int len = pushA.length;
        int p1 = len - 1;
        int p2 = 0;
        while (p1 >= 0 && p2 < len) {
            if (pushA[p1] == popA[p2]) { //相等
                p1--;
                p2++;
            } else if (stack.isEmpty()) { //不相等且栈为空
                stack.push(popA[p2++]);
            } else if (pushA[p1] == stack.peek()) { //不相等且栈不为空
                stack.pop();
                p1--;
            } else { //不相等跟栈顶也不一样
                stack.push(popA[p2++]);
            }
        }
        return stack.isEmpty();
    }
}