package main.java.leetcode.leetcode_me;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @program: JalrAlgsBin
 * @description: 无重复的最长子串
 * <p>
 * Created by jalr on 2019/8/24.
 */
class leetcode_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        HashSet<Character> wnd = new HashSet<>();
        int len = s.length();
        int p1 = 0;
        int p2 = 0;
        while (p1 < len && p2 < len) {
            if (!wnd.contains(s.charAt(p2))) {
                wnd.add(s.charAt(p2++));
                maxHeap.offer(p2 - p1);
            } else {
                wnd.remove(s.charAt(p1++));
            }
        }
        return maxHeap.poll();
    }
}