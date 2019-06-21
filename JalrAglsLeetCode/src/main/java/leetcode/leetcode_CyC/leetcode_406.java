package leetcode.leetcode_CyC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution406 {

    public static int[][] reconstructQueue(int[][] people) {

        // [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

        // [[7,0], [7,1], [6,1], [5,0], [5,2] [4,4]]

        // [[7,0], [5,0], [7,1], [6,1], [5,2] [4,4]]

        /*
        */
        if (people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }

        if (people.length == 1) {
            return people;
        }

        // 按照身高降序排序；若身高相同，则按照个数来升序排序，因为身高相同，前面的个数肯定小于后面的，不存在身高相同，个数还相等的
        // [身高，个数]
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) { // 身高相同
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else if (o1[1] < o2[1]) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else if (o1[0] > o2[0]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        
        printArray(people);

        ArrayList<int[]> res = new ArrayList<>();

        for (int[] p : people) {
            res.add(p[1], p);
        }

        int[][] result = res.toArray(new int[res.size()][]);

      
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

        reconstructQueue(arr);

    }

    public static void printArray(int[][] arr) {
        for (int[] a : arr) {
            System.out.print("[ " + a[0] + ", " + a[1] + "]" + ",  ");
        }
    }

    public static void printAwser(int[][] people) {
        System.out.println();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        printArray(people);
        System.out.println();
    }
}