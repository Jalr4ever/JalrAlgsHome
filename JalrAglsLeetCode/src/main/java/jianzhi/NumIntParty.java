package main.java.jianzhi;

/**
 * @program: JalrAlgsBin
 * @description: 数的整数次方
 * <p>
 * Created by jalr on 2019/9/4.
 */
public class NumIntParty {

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
