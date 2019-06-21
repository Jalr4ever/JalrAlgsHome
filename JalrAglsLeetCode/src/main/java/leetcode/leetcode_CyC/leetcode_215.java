package leetcode.leetcode_CyC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution215 {

    public static void main(String[] args) {

    }

    /**
     * 小顶堆 - 使用内置的数据结构
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestIIII(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();// 删除堆顶结点
            }
        }
        return minHeap.peek();

    }

    /**
     * 
     * 大顶堆 - 使用内置的优先队列
     * 
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestIII(int[] nums, int k) {
        int KIndex = nums.length - k + 1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // 大顶堆
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > KIndex) {
                maxHeap.poll(); //删除堆顶结点
            }
        }
        return maxHeap.peek();
    }

    /**
     * 内置排序选择
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestI(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 快速选择 - 非递归选择
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestIINonRec(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int KIndex = nums.length - k;
        if (right == 0) {
            return nums[0];
        }

        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == KIndex) {
                return nums[KIndex]; // 此时是元素有序后的第 K 个位置
            } else if (pivot < KIndex) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }

    /**
     * 快速选择-数组倒数第 K 个元素-递归选择
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestII(int[] nums, int k) {

        int left = 0;
        int right = nums.length - 1;
        int kIndex = nums.length - k; // 对应有序数组真正的倒数第 K 个下标

        if (right == 0) {
            return nums[0]; // 只有一个元素
        }

        int[] KEle = new int[2];
        KEle[0] = -1; // 不存在
        KEle[1] = kIndex;

        quickSelect(nums, left, right, KEle);

        return KEle[0];
    }

    private void quickSelect(int[] nums, int left, int right, int[] kthele) {

        if (left > right) {
            return;
        }

        int pivot = partition(nums, left, right);

        if (pivot == kthele[1]) {
            kthele[0] = nums[pivot];
            return;
        } else if (nums.length == 2) {
            kthele[0] = nums[1 - pivot];
            return;
        }

        quickSelect(nums, left, pivot - 1, kthele);
        quickSelect(nums, pivot + 1, right, kthele);
    }

    private int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int temp = nums[left];

        while (i < j) {

            while (i < j && nums[j] >= temp) {
                j--;
            }

            while (i < j && nums[i] <= temp) {
                i++;
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }

        nums[left] = nums[i];
        nums[i] = temp; // 基数归位
        return i;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}