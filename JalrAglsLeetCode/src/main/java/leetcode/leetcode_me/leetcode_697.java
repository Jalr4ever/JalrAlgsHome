package leetcode.leetcode_me;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution697 {
    public static void main(String[] args) {
        int[] a = { 2, 1 };
        System.out.println(findShortestSubArray(a));

    }

    public static int findShortestSubArray(int[] nums) {

        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int degree = 0;

        int minInterval = nums.length;
        Map<Integer, Integer> frequencyCounter = new HashMap<>();

        for (int num : nums) {
            int newFrequncy = frequencyCounter.getOrDefault(num, 0) + 1;
            frequencyCounter.put(num, newFrequncy);
            if (newFrequncy > degree) {
                degree = newFrequncy;
            }
        }

        for (Entry<Integer, Integer> entry : frequencyCounter.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val == degree) { // 与最大的度相等的键
                int intervalLen = searchInternalLen(nums, degree, key);
                if (intervalLen < minInterval) {
                    minInterval = intervalLen;
                }
            }
        }

        return minInterval <= 1 ? 1 : minInterval;
    }

    private static int searchInternalLen(int[] nums, int degree, int degreeKey) {
        int p1 = -1;
        int p2 = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == degreeKey) {
                if (p1 == -1) {
                    p1 = i;
                } else if (degree == 1) {
                    p2 = i;
                }
                --degree;
            }
        }
        return p2 - p1 + 1;
    }

}