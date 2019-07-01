package jianzhi;

import java.util.Stack;

/**
 * 题目：两个栈实现对垒 题解：入栈的时候，全都入到 stack1；入完了就要把元素全都入到 stack2 出栈的时候，从 stack2 出，所以
 * stack1 就像缓存一样
 */
class TowStackForQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        refreshCache();
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        refreshCache();
        return stack2.pop();
    }

    private void refreshCache() {

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

}