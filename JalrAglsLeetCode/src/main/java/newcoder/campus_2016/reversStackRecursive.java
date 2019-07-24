package app;

import java.util.Stack;

class ReverseStack {
    public int[] reverseStackRecursively(int[] stack, int top) {
        reverse(stack, top, top);
        return stack;
    }

    private int reverse(int[] stack, int top, int bottom) {

        int cur = stack[--top];

        if (top == 0) {
            stack[--bottom] = cur;
            return bottom;
        }

        int lastBottom = reverse(stack, top, bottom);
        stack[--lastBottom] = cur;
        return lastBottom;
    }
}

class ReverseStackII {

    public void reverseStackRecursively(Stack<Integer> stack) {
        reverse(stack);
    }

    private int getLastAndDelete(Stack<Integer> stack) {
        int cur = stack.pop();
        if (stack.isEmpty()) {
            return cur;
        }
        int last = getLastAndDelete(stack);
        stack.push(cur);
        return last;
    }

    private void reverse(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        int cur = getLastAndDelete(stack);
        reverse(stack);
        stack.push(cur);

    }
}

class Te {
    public static void main(String[] args) {
    }
}
