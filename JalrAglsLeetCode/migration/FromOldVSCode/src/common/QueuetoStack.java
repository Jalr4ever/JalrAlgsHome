package common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈，在 pop 和 peek 上下心思，每次针对的都是队尾元素，每次操作完更新 data 引用为 help
 * 
 * @param data 存放栈元素的队列
 * @param help 每次栈顶元素，也就是队尾元素时存下它前面一截的辅助队列
 * 
 */

public class QueuetoStack {

    private Queue<Integer> data = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public void push(int obj) {
        data.add(obj);
    }

    public int pop() {
        migrate();
        int Qtail = data.poll();
        swap();
        return Qtail;
    }

    public int peek() {
        migrate();
        int Qtail = data.poll();
        help.add(Qtail);
        swap();
        return Qtail;
    }

    private void migrate() {
        while (data.size() > 1) {
            help.add(data.poll());
        }
    }

    private void swap() {
        Queue<Integer> temp = data;
        data = help;
        help = temp;
    }
}