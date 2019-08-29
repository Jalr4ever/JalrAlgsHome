package main.java.jianzhi;

/**
 * @program: JalrAlgsBin
 * @description: 剑指 - 二进制中 1 的个数
 * <p>
 * Created by jalr on 2019/8/25.
 */
public class BinaryOneCount {
    public int NumberOf1(int n) {
        char[] nums = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getPow(3, -1));
    }

    private static int getPow(int base, int exponent) {
        if (base == 0 || exponent == 1) {
            return base;
        }

        if (exponent == 0) {
            return 1;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        }

        int pow = getPow(base, exponent / 2) * base;
        if (exponent % 2 != 0) {
            pow *= base;
        }
        return isNegative ? 1 / pow : pow;
    }
}


