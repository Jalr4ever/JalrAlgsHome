package main.java.leetcode.leetcode_CyC;

/**
 * @program: JalrAlgsBin
 * @description: 小于 n 的质数个数
 * <p>
 * Created by jalr on 2019/8/18.
 */
public class leetcode_204 {
    public int countPrimes(int n) {
        if (n <= 1){
            return 0;
        }
        boolean[] isPrimes = new boolean[n + 1]; //若 n = 2 的情况
        int count = 0;
        for (int i = 2; i < n; i++){
            if (isPrimes[i]){
                continue;
            }
            count++;
            for (long j = ((long) i * i); j < n; j += i){
                isPrimes[(int)j] = true;
            }
        }
        return count;
    }
}