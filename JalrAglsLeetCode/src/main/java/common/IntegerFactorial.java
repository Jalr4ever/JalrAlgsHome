package main.java.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @program: JalrAlgsBin
 * @description: 牛客 - 整数阶乘
 * <p>
 * Created by jalr on 2019/8/13.
 */
public class IntegerFactorial {
    public static void main(String[] ars) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        System.out.println(solution(n));

    }

    //递归版
    private static BigInteger solution(int n){
        if(n == 1){
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(n).multiply(solution(n - 1));
    }

    //迭代版
    private static BigInteger solutionII(int n){
        BigInteger res = BigInteger.valueOf(n);
        for (int i = n - 1; i >= 1; i--){
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
