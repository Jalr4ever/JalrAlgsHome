package main.java.jianzhi;

/**
 * @program: JalrAlgsBin
 * @description: 剑指 - 数的整数次方
 * <p>
 * Created by jalr on 2019/8/25.
 */
class NumIntExponent {
    public double Power(double base, int exponent) {
        if (base == 0 || exponent == 1) {
            return base;
        }

        if (exponent == 0) {
            return 1;
        }

        boolean isNegative = false; //负数判断
        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            pow = pow * base;
        }
        return isNegative ? 1 / pow : pow;
    }
}