package newcoder.campus_2016;

/**
 * 
 * 给定一个 NxN 的矩阵，和矩阵的阶数 N,返回旋转后的NxN矩阵
 * 
 * @param mat[tR][tC+i] 上长
 * @param mat[tR+i][bC] 右宽
 * @param mat[bR][bC-i] 下长
 * @param mat[bR-i][tC] 左宽
 */

class Rotate {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        rotateMatrix(arr, 3);
    }

    public static int[][] rotateMatrix(int[][] mat, int n) {

        if (mat == null || mat.length != mat[0].length || mat.length != n || n == 1) {
            return mat;
        }

        int tR = 0;
        int tC = 0;
        int bR = mat.length - 1;
        int bC = mat[0].length - 1;
        rotate(mat, tR, tC, bR, bC);
        return mat;

    }

    private static void rotate(int[][] mat, int tR, int tC, int bR, int bC) {

        while (tR <= bR && tC <= bC) {
            int times = bC - tC;
            for (int i = 0; i < times; i++) {
                int temp = mat[tR][tC + i];
                mat[tR][tC + i] = mat[bR - i][tC];
                mat[bR - i][tC] = mat[bR][bC - i];
                mat[bR][bC - i] = mat[tR + i][bC];
                mat[tR + i][bC] = temp;
            }
            ++tC;
            ++tR;
            --bC;
            --bR;
        }

    }
}