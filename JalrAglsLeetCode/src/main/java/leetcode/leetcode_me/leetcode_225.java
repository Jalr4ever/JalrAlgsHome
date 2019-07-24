package main.java.leetcode.leetcode_me;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: JalrAlgsBin
 * @description: 两个队列实现栈
 * <p>
 * Created by jalr on 2019/7/18.
 */
class MyStack {
    /**
     * Initialize your data structure here.
     */
    Queue<Integer> data;
    Queue<Integer> help;

    public MyStack() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        data.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        migrate();
        int val = data.poll();
        swap();
        return val;
    }

    /**
     * Get the top element.
     */
    public int top() {
        migrate();
        int val = data.poll();
        help.add(val);
        swap();
        return val;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return data.isEmpty();
    }

    private void migrate() {
        while (data.size() > 1) {
            help.add(data.poll());
        }
    }

    private void swap() {
        Queue temp = data;
        data = help;
        help = temp;
    }
}
