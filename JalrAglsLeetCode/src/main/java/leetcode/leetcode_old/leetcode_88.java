package leetcode.leetcode_old;

/*

给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]


*/

class Solution88 {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 0, 0, 0 };
        int[] b = { 2, 5, 6 };
        merge(a, 3, b, 3);
        for (int i : a) {
            System.out.print(i + "   ");
        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] res = new int[m + n];
        int count = 0;
        if (nums2 == null || nums1 == null) {
            return;
        }
        while ((p1 < m && p2 < n)) {
            if (nums1[p1] < nums2[p2]) {
                res[count++] = nums1[p1++];
            } else {
                res[count++] = nums2[p2++];
            }
        }

        while (p1 < m) {
            res[count++] = nums1[p1++];
        }

        while (p2 < n) {
            res[count++] = nums2[p2++];
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }

    }
}