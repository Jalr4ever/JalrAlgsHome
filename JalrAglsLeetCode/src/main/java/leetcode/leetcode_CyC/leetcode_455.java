package leetcode.leetcode_CyC;

import java.util.Arrays;
import java.util.PriorityQueue;

/*

示例 1:

输入: [1,2,3], [1,1]

输出: 1

解释: 
你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
所以你应该输出1。
示例 2:

输入: [1,2], [1,2,3]

输出: 2

解释: 
你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
你拥有的饼干数量和尺寸都足以让所有孩子满足。
所以你应该输出2.

*/
class Solution455 {

    // 排序（贪心） - 12 ms, 在所有Java提交中击败了 99.49%
    public int findContentChildrenII(int[] g, int[] s) {

        int res = 0;

        int gPointer = 0, sPointer = 0; // 维护两个指针

        Arrays.sort(g);

        Arrays.sort(s);

        while (gPointer < g.length && sPointer < s.length) {
            if (g[gPointer] <= s[sPointer]) {
                res++;
                gPointer++;
                sPointer++;
            } else {
                sPointer++;
            }
        }

        return res;
    }

    // 堆解法 - 58 ms, 在所有Java提交中击败了 7.68%
    public int findContentChildrenI(int[] g, int[] s) {

        int res = 0;

        PriorityQueue<Integer> gMinHeap = new PriorityQueue<>(); // 食量小顶堆

        PriorityQueue<Integer> sMinHeap = new PriorityQueue<>(); // 饼干小顶堆

        for (int var : g) {
            gMinHeap.add(var);
        }

        for (int var : s) {
            sMinHeap.add(var);
        }

        while (!gMinHeap.isEmpty() && !sMinHeap.isEmpty()) {
            if (sMinHeap.peek() >= gMinHeap.peek()) {
                sMinHeap.poll();
                gMinHeap.poll();
                res++;
            } else {
                sMinHeap.poll();
            }
        }
        return res;
    }
}