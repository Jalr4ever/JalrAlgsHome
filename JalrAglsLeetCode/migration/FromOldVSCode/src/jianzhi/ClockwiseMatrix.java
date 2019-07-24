package jianzhi;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * 顺时针打印矩阵，首先通过左上角的顶点和右下角的顶点确定矩阵
 * 
 * @param tR- top row, 左上角的行
 * @param tC- top col，左上角的列
 * @param bR- bottom row，右下角的行
 * @param bC- bottom col，右下角的列
 */

public class ClockwiseMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };
        ArrayList<Integer> res = printMatrix(matrix);
        Iterator<Integer> it = res.iterator();
        System.out.println();
        while (it.hasNext()) {
            System.out.print(it.next().toString() + " ");
        }
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        ArrayList<Integer> res = new ArrayList<>();

        int tR = 0;
        int tC = 0;
        int bR = matrix.length - 1;
        int bC = matrix[0].length - 1;

        while (tR <= bR && tC <= bC) {
            if (tR == bR) {
                for (; tC <= bC; tC++) {
                    res.add(matrix[tR][tC]);
                }
            } else if (tC == bC) {
                for (; tR <= bR; tR++) {
                    res.add(matrix[tR][tC]);
                }
            } else {

                for (int i = tC; i <= bC; i++) { // 上行
                    res.add(matrix[tR][i]);
                }

                for (int i = tR + 1; i <= bR; i++) { // 右宽
                    res.add(matrix[i][bC]);
                }

                for (int i = bC - 1; i >= tC; i--) { // 下长
                    res.add(matrix[bR][i]);
                }

                for (int i = bR - 1; i >= tR + 1; i--) {// 左宽
                    res.add(matrix[i][tC]);
                }

                ++tC;
                ++tR;
                --bC;
                --bR;
            }
        }
        return res;
    }
}