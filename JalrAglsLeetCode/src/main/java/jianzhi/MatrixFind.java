package main.java.jianzhi;

/**
 * @program: JalrAlgsBin
 * @description: 二维数组中的查找
 * <p>
 * Created by jalr on 2019/7/21.
 */
public class MatrixFind {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int c = array[0].length - 1, r = 0;
        while (c >= 0 && r < array.length) {
            if (target == array[r][c]) {
                return true;
            } else if (target > array[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}
