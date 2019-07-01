package newcoder.campus_2016;

class ReverseStack {
    public static void main(String[] args) {
        int[] stack = { 5, 4, 3, 2, 1 };
        int[] stacknew = reverseStackRecursively(stack, 5);
        for (int i : stacknew) {
            System.out.print(i + "  ");
        }

    }

    public static int[] reverseStackRecursively(int[] stack, int top) {
        if (stack == null || stack.length == 0 || top == 0) {
            return null;
        }

        reverseStack(stack, 0, top, top);
        return stack;

    }

    private static int reverseStack(int[] stack, int start, int top, int end) {
        if (stack == null || stack.length == 0 || top == 0) {
            return -1;
        }
        int current = stack[--top];
        if (top == start) { // 栈底
            stack[end - 1] = current;
            return end - 1;
        } else {
            int nextIndex = reverseStack(stack, start, top, end);
            stack[nextIndex - 1] = current;
            return nextIndex - 1;
        }
    }

}