package main.java.newcoder.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @program: JalrAlgsBin
 * @description: 牛客网 - 数组最长连续子区间
 * <p>
 * Created by jalr on 2019/8/17.
 */
public class MaxSubArrLen {
    public static void main(String[] a) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        System.out.println(getLen(nums));
    }

    private static int getLen(int[] nums) {
        Arrays.sort(nums);
        int len = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){ //相等跳过
                continue;
            } else if(nums[i] - nums[i - 1] == 1){ //连续加一
                len++;
            } else{ //不连续开始新一统计
                len = 1;
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}
