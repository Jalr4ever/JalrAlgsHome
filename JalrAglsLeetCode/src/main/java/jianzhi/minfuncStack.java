package jianzhi;

import java.util.Stack;

/**
 * 题目：实现包含能获取栈里最小值功能的栈
 */
class SolutionminFuncStack {
    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackMinData = new Stack<>();

    public void push(int node) {
        stackData.push(node);
        if(!stackMinData.isEmpty()){
            int min = node < stackMinData.peek() ? node :stackMinData.peek();
            stackMinData.push(min);
        } else {
            stackMinData.push(node);
        }
    }

    public void pop() {
        if(stackData.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        stackData.pop();
        stackMinData.pop();
    }

    public int top() {
        if(stackData.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return stackData.peek();
    }

    public int min() {
        if(stackMinData.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return stackMinData.peek();
    }
}