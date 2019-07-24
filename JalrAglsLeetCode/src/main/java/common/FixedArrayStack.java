package common;

/**
 * 定容的栈
 * 
 * @param size 当前栈的容量，其实也可以用 arr.length 来限定
 * @param top  栈顶指针
 */

public class FixedArrayStack {
    private int[] arr;
    private int top;
    private int size;

    public FixedArrayStack(int size) {
        this.size = size;
        arr = new int[size];
        top = 0;
    }

    public int pop() {
        if (top == 0) {
            throw new RuntimeException("Pop error, stack is null.");
        }
        return arr[--top];
    }

    public int peek() {
        if (top == 0) {
            throw new RuntimeException("Peek error, stack is null.");
        }
        return arr[top - 1];
    }

    public void push(int num) {
        if (top == this.size) {
            throw new RuntimeException("Push error, unexpected size.");
        }

        this.arr[top++] = num;
    }

}