package main.java.leetcode.leetcode_category_top_ten.array;

/**
 * @program: JalrAlgsBin
 * @description: 寻找两个有序数组的中位数
 * <p>
 * Created by jalr on 2019/10/5.
 */
class leetcode_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int mid1 = (n + m +1) / 2;
        int mid2 = (n + m + 2) / 2;
        return (find(nums1, 0, nums2, 0, mid1) +
                find(nums1, 0, nums2, 0, mid2)) /
                2.0;
    }
    private int find(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) { //数组一越界，直接在数组二求中位数
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) { //数组二越界，直接在数组一求中位数
            return nums1[start1 + k - 1];
        }
        if (k == 1) { //剩下一个，求第 1 小，那么直接比较俩数组第一个数
            return Math.min(nums1[start1], nums2[start2]);
        }
        int p1 = start1 + k / 2 - 1;//nums1 的第 k / 2 个位置
        int p2 = start2 + k / 2 - 1;//nums2 的第 k / 2 个位置
        int cur1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
        int cur2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;
        if (cur1 < cur2) {
            return find(nums1, p1 + 1, nums2, start2, k - k / 2);
        } else {
            return find(nums1, start1, nums2, p2 + 1, k - k / 2);
        }
    }
}
