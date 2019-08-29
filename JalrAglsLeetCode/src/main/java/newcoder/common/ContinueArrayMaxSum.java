package main.java.newcoder.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: JalrAlgsBin
 * @description: 牛客 - 求连续子数组的最大和
 * <p>
 * Created by jalr on 2019/8/13.
 */
public class ContinueArrayMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++){
            nums[i] = Integer.parseInt(str[i]);
        }
        int end = nums[nums.length - 1];
        int start = nums[0];
        Long[] dp = new Long[nums.length];
        long cur = 0;
        long dpi = 0;
        for(int i = 0; i < nums.length; i++){
            for (int j = i; j < nums.length; j++){
                cur += nums[j];
                if(cur > dpi){
                    dpi = cur;
                }
            }
            dp[i] = dpi;
            dpi = 0;
            cur = 0;
        }
        Arrays.sort(dp, Comparator.reverseOrder());
        System.out.println(dp[0] < 0 ? 0 : dp[0]);
    }
}
