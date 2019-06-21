package leetcode.leetcode_CyC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

class Solution {

    // 基于交换
    public void sortColorsIII(int[] nums) {
        // 三个指针依次指向三个数的“正确位置” 将数组的数交互归位
    }

    @SuppressWarnings("all")
    // 桶
    public void sortColorsII(int[] nums) {
        HashMap<Integer, Integer> frequencyCount = new HashMap<>();

        int update_pointer = 0;
        for (int num : nums) {
            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] buckets = new ArrayList[3]; // 因为只有 0 1 2

        for (int key : frequencyCount.keySet()) {
            buckets[key] = new ArrayList<>();
            buckets[key].add(frequencyCount.get(key));
        }

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                for (int j = 0; j < buckets[i].get(0); j++) {
                    nums[update_pointer++] = i;
                }
            }

        }

    }

    // 堆
    public void sortColorsI(int[] nums) {

        HashMap<Integer, Integer> frequencyCount = new HashMap<>();

        int update_pointer = 0;

        // 统计每个数字的数量
        for (int num : nums) {
            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
        }

        // 维护一个数字的小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : frequencyCount.keySet()) {
            minHeap.add(num);
        }

        // 求结果
        while (!minHeap.isEmpty()) {
            for (Entry<Integer, Integer> entry : frequencyCount.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (key == minHeap.peek()) {
                    for (int i = 0; i < value; i++) {
                        nums[update_pointer++] = key;
                    }
                    minHeap.poll(); // 添加完出队
                    frequencyCount.remove(key); // 操作完该数字移除掉
                    break;
                }
            }
        }

    }
}