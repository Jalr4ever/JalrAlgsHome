package leetcode.leetcode_CyC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Map.Entry;

// 维护大小为 K 的小顶堆，会删除 length - k 次 “最小” 的元素，剩下的 topK 大的一批了！
class Solution347 {
    public static void main(String[] args) {
        System.out.println("pro?");
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> frequencyCount = new HashMap<>(); // 数字频率统计
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 小顶堆
        ArrayList<Integer> res = new ArrayList<>();

        for (int num : nums) {
            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
        }

        System.out.println(frequencyCount.values());

        // 将值也就是频率入队
        for (int num : frequencyCount.values()) {
            System.out.println(num);
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // 队头元素出队

            }
        }

        // 根据统计的频率（值）取得对应的健（数字）
        while (!minHeap.isEmpty()) {
            for (Entry<Integer, Integer> entry : frequencyCount.entrySet()) {
                if (minHeap.isEmpty()) {
                    break;
                }
                int top = minHeap.peek();
                int getVal = entry.getValue();
                if (top == getVal) {
                    res.add(entry.getKey());
                    minHeap.poll();
                }
            }
        }

        return res;
    }
}