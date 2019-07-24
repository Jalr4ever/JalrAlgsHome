package main.java.newcoder.ji_bi_te;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JalrAlgsBin
 * @description: 牛客 - 吉比特最大差值
 * <p>
 * Created by jalr on 2019/7/18.
 */
public class MaxDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        String[] nums = bf.readLine().split(" ");
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        System.out.println(getResult(arr));
    }

    private static int getResult(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }

        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] maxBucket = new int[len + 1];
        int[] minBucket = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];

        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
            min = min < arr[i] ? min : arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int bucketID = getBucket(arr[i], min, max, len);
            maxBucket[bucketID] = hasNum[bucketID] ? Math.max(maxBucket[bucketID], arr[i]) : arr[i];
            minBucket[bucketID] = hasNum[bucketID] ? Math.min(minBucket[bucketID], arr[i]) : arr[i];
            hasNum[bucketID] = true;
        }

        int res = 0;
        int lastMax = maxBucket[0];
        for (int i = 1; i < hasNum.length; i++) {
            if (hasNum[i]) {
                int val = minBucket[i] - lastMax;
                res = res > val ? res : val;
                lastMax = maxBucket[i];
            }
        }

        return res;
    }

    private static int getBucket(long num, long min, long max, long len) {
        return (int) ((num - min) * len / (max - min));
    }
}
