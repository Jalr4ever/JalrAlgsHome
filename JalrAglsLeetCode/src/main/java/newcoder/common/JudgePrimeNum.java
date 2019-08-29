package main.java.newcoder.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JalrAlgsBin
 * @description: 牛客网 - 判断素数
 * <p>
 * Created by jalr on 2019/8/23.
 */
public class JudgePrimeNum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        System.out.println(isPrime(num));
    }

    private static String isPrime(int num){
        if (num <= 2 || num % 2 == 0){
            return "no";
        }
        for (int i = 3; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                return "no";
            }
        }
        return "yes";
    }
}
