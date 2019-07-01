package jianzhi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class SolutionSlidingWin {
    public static void main(String[] args) {
        int[] test = { 2, 3, 4, 2, 6, 2, 5, 1 };
        new SolutionSlidingWin().maxInWindowsI(test, 3);
    }

    public ArrayList<Integer> maxInWindowsI(int[] num, int size) {

        ArrayList<Integer> result = new ArrayList<>();

        if (num == null || num.length < size || size == 0) {
            return result;
        }

        LinkedList<Integer> maxdeque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            // 保证插入到大元素的后面
            while (!maxdeque.isEmpty() && num[maxdeque.peekLast()] <= num[i]) {
                maxdeque.pollLast();
            }

            // 插入到大元素的后面, 保证队头一定是最大的
            maxdeque.addLast(i);

            // 检查过期元素, 在达到 size 时才有第一次过期
            if (maxdeque.peekFirst() == i - size) {
                maxdeque.pollFirst();
            }

            // 检查是否出现滑动窗口, 出现将最大值加入结果
            if (i >= size - 1) {
                result.add(num[maxdeque.peekFirst()]);
            }
        }

        return result;
    }

    public ArrayList<Integer> maxInWindowsII(int[] num, int size) {

        if (num == null) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();

        if (size == 0) {
            return result;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < num.length; i++) {
            if (maxHeap.size() < size) {
                maxHeap.add(num[i]);
                if (maxHeap.size() == size) {
                    result.add(maxHeap.peek());
                    maxHeap.remove(num[i + 1 - size]); // 移除过期元素
                }
            }
        }

        return result;
    }
}