package common;

import java.util.Stack;

/**
 * 使用栈实现队列，每次存放完要刷新到数据栈，每次 peek 和 pop 时也要刷新一下缓存
 * 
 * @param cache 用来暂时存放队列元素的缓存栈
 * @param data  真正存放队列元素的数据栈
 * 
 */
public class StacktoQueue {

    private Stack<Integer> cache = new Stack<>();
    private Stack<Integer> data = new Stack<>();

    public void add(int obj) {
        cache.push(obj);
        refreshCache();
    }

    public int peek() {
        refreshCache();
        return data.peek();
    }

    public int pop() {
        refreshCache();
        return data.pop();
    }

    private void refreshCache() {
        if (data.isEmpty()) {
            while (!cache.isEmpty()) {
                data.push(cache.pop());
            }
        }
    }

}