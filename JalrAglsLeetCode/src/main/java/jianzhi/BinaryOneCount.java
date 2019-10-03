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
}


