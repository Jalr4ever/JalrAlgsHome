package main.java.newcoder.common;

/**
 * @program: JalrAlgsBin
 * @description: 之字形打印矩阵
 * <p>
 * Created by jalr on 2019/7/21.
 */
public class PrinterMat {
    public int[] printMatrix(int[][] mat, int n, int m) {
        int[] res = new int[n * m];
        int resIndex = 0;
        boolean isReverse = false;
        for (int i = 0; i < n; i++) {
            int col = isReverse ? m - 1 : 0;
            if (!isReverse) {
                while (col < m) {
                    res[resIndex++] = mat[i][col++];
                }
                isReverse = true;
            } else {
                while (col >= 0) {
                    res[resIndex++] = mat[i][col--];
                }
            }
        }

        return res;
    }
}
