package main.java.leetcode.leetcode_me;

import java.util.PriorityQueue;

/**
 * @program: JalrAlgsBin
 * @description: 最长公共前缀
 * <p>
 * Created by jalr on 2019/8/31.
 */

class leetcode_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < strs.length; i++) {
            minHeap.offer(strs[i].length());
        }
        int len = minHeap.poll();
        StringBuilder sb = new StringBuilder();
        boolean isNeed = true;
        for (int i = 0; i < len && isNeed; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) == strs[j - 1].charAt(i)) {
                    continue;
                }
                isNeed = false;
                break;
            }
            if (isNeed) {
                sb.append(strs[0].charAt(i));
            }
        }
        return sb.toString();
    }
}
