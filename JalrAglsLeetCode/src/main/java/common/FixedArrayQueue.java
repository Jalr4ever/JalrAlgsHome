package common;

/**
 * 定容的循环队列，如果不用一个额外的 size 来指定大小，两个指针耦合度过高，实现起来比较难
 * 
 * @param start 队头指针
 * @param end   队尾指针
 * @param size  当前队列的元素个数（大小）
 */

public class FixedArrayQueue {

    private int[] arr;
    private int size;
    private int start;
    private int end;

    public FixedArrayQueue(int initSize) {
        this.arr = new int[initSize];
        this.size = 0;
        this.start = this.end = 0;
    }

    public void add(int num) {
        if (this.size == this.arr.length) {
            throw new RuntimeException("Push error, queue is full");
        }
        start = start % this.arr.length;
        arr[start++] = num;
        size++;
    }

    public int peek() {
        if (this.size == 0) {
            throw new RuntimeException("Peek error, queue is null");
        }
        end = end % this.arr.length;
        return arr[end];
    }

    public int poll() {
        if (this.size == 0) {
            throw new RuntimeException("Poll error, queue is null");
        }

        size--;
        end = end % this.arr.length;
        return arr[end++];
    }

}