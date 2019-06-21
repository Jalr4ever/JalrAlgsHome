package leetcode.leetcode_CyC;

import java.util.Arrays;
import java.util.Comparator;

class Solution452 {
    public int findMinArrowShots(int[][] points) {

        // 气球组成：[始坐标, 末坐标] , 举例按末坐标排序后的：[[1,6], [2,8], [7,12], [10,16]]

        if(points.length == 1 ){
            return 1;
        }

        if(points.length == 0){
            return 0;
        }

        int res = 1; // 假设气球全部相交，一开始就一支箭可以搞定
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { // 将每个区间按照末坐标升序排列
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int end_index = points[0][1];
        int start_index;

        for (int i = 1; i < points.length; i++) {
            start_index = points[i][0];
            if (start_index > end_index) {
                res++;
                end_index = points[i][1];
            }
        }

        return res;
    }
}