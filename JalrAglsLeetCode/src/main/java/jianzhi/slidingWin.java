package app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> res = new ArrayList<>();

        if (num == null || size == 0) {
            return res;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < num.length; i++) {
            maxHeap.add(num[i]);
            if (i >= size - 1) {
                res.add(maxHeap.peek());
                maxHeap.remove((Integer) num[i - (size - 1)]);
            }
        }
        return res;
    }
}

class SolutionII {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();

        if (num == null || size == 0) {
            return res;
        }

        LinkedList<Integer> maxWin = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {

            while (!maxWin.isEmpty() && num[maxWin.peekLast()] < num[i]) {
                maxWin.pollLast();
            }
            maxWin.addLast(i);

            while (maxWin.peekFirst() < i - (size - 1)) {
                maxWin.pollFirst();
            }

            if (i >= size - 1) {
                res.add(num[maxWin.peekFirst()]);
            }
        }

        return res;
    }
}

class Teee {
    public static void main(String[] args) {
        int[] num = { 2, 3, 4, 2, 6, 2, 5, 1 };
        // Solution ss = new Solution();
        // ArrayList<Integer> res = ss.maxInWindows(num, 3);
        SolutionII s2 = new SolutionII();
        ArrayList<Integer> res = s2.maxInWindows(num, 3);
        System.out.println("now");
    }
}
