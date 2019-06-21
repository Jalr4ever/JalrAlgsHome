package leetcode.leetcode_CyC;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

class Solution451 {

    public String frequencySortII(String s) {

        char[] value = s.toCharArray();

        StringBuilder res = new StringBuilder();

        HashMap<Character, Integer> frequencyCount = new HashMap<>();

        // 统计频率
        for (char c : value) {
            frequencyCount.put(c, frequencyCount.getOrDefault(c, 0) + 1);
        }
        @SuppressWarnings("all")
        // 设置桶, 桶的每一个位置存的是同频率的字符，频率就是桶的的下标
        ArrayList<Character>[] buckets = new ArrayList[value.length + 1];

        for (Entry<Character, Integer> entry : frequencyCount.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (buckets[val] == null) {
                buckets[val] = new ArrayList<>();
            }
            buckets[val].add(key);
        }

        for (int i = buckets.length - 1; i >= 1; i--) { //最后一个位置不用

            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) { // 插入频率的次数那么多次
                        res.append(c);
                    }
                }
            }

        }

        return res.toString();

    }

    public String frequencySortI(String s) {
        HashMap<Character, Integer> frequencyCount = new HashMap<>();

        char[] value = s.toCharArray();

        StringBuilder res = new StringBuilder();

        // 统计字符出现频率
        for (char var : value) {
            frequencyCount.put(var, frequencyCount.getOrDefault(var, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (Integer var : frequencyCount.values()) {
            maxHeap.add(var);
        }

        // 将 topK 数组依次插入结果中
        while (!maxHeap.isEmpty()) {
            for (Entry<Character, Integer> entry : frequencyCount.entrySet()) {
                char key = entry.getKey();
                int val = entry.getValue();
                if (val == maxHeap.peek()) {
                    for (int i = 0; i < val; i++) {
                        res.append(key);
                    }
                    maxHeap.poll();
                    frequencyCount.remove(key);
                    break;
                }
            }
        }

        return res.toString();
    }
}