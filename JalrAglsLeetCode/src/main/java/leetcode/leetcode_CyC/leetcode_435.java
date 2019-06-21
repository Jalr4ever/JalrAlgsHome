package leetcode.leetcode_CyC;

import java.util.Arrays;
import java.util.Comparator;

/*

最最关键的是如何判断不重叠的区间？

思路：二维数组里的每一个元素是一个数组，里面存放着 [下界，上界] 两个参数，此时只要将二维数组里的元素按照其
上界进行排序，此时脑子里想象一下，当数组里的上界是升序的华，只要下一个元素的下界小于当前元素的上界就是越界了！
判断越界，统计次数即可。

[ [1,2], [2,3], [3,4], [1,3] ]

[ [1,2], [2,3], [1,3], [3,4] ]

*/

//因为既然“下一个”的下界比当前上界小，要保证不重叠，要跟最大的比，那么还是要和原来的比！
class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length <= 1) {
            return 0;
        }

        int res_delete = 0;

        // 按照 [下界，上界] 的上界来排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] == o2[1]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        // 遍历数组检查下界
        int upper_bound = intervals[0][1];
        int lower_bound;
        for (int i = 1; i < intervals.length; i++) {
            lower_bound = intervals[i][0];
            if (lower_bound < upper_bound) {
                res_delete++;
                continue; // 这里是重点，也是贪心的体现
            }
            upper_bound = intervals[i][1];
        }

        return res_delete;

    }

}