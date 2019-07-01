package app;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] tmp = br.readLine().split(" ");
        br.close();
        int N = tmp.length;
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tmp[i]);
        }

        System.out.println(solution(nums, N));

    }

    private static int solution(int[] nums, int length) {

        if (nums == null || nums.length < 2) {
            return 0;
        }

        int len = length;
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            maxNum = Math.max(nums[i], maxNum);
            minNum = Math.min(nums[i], minNum);
        }

        if (maxNum == minNum) {
            return 0;
        }

        boolean[] hasNum = new boolean[len + 1];
        int[] bucketMaxNum = new int[len + 1];
        int[] bucketMinNum = new int[len + 1];

        for (int i = 0; i < len; i++) {
            int bucketID = getBucketID(nums[i], minNum, maxNum, len);
            bucketMaxNum[bucketID] = hasNum[bucketID] ? Math.max(nums[i], bucketMaxNum[bucketID]) : nums[i];
            bucketMinNum[bucketID] = hasNum[bucketID] ? Math.min(nums[i], bucketMinNum[bucketID]) : nums[i];
            hasNum[bucketID] = true;
        }

        int res = 0;
        int lastMaxNum = bucketMaxNum[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, bucketMinNum[i] - lastMaxNum);
                lastMaxNum = bucketMaxNum[i];
            }
        }

        return res;
    }

    private static int getBucketID(int num, int min, int max, int len) {
        return (int) ((num - min) * len / (max - min));
    }
}