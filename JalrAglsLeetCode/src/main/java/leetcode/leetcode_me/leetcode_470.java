/**
 * The rand7() API is already defined in the parent class SolBase. public int
 * rand7();
 * 
 * @return a random integer in the range 1 to 7
 */
class Solution {
    public int rand10() {
        int res = 0;
        while (true) {
            // 1. max - 转换成七进制数：42+6 = 48，区间：[0, 48]
            res = 7 * (rand7() - 1) + rand7() - 1;
            // 2. 取余映射 - 最接近 48 的 10 的倍数，为 4 , 均等区间在 [0, 39]
            if (res < 40) {
                return res % 10 + 1;
            }
        }
    }

    public static int rand17() {
        int v = (rand7() - 1) * 7 + rand7() - 1;
        if (v <= 40) {
            return v % 10 + 1;
        }
        return rand17();
    }

    public static int rand7() {
        int r = 7;
        return (int) ((r) * Math.random() + 1); // 范围 [1, r+1)，也就是 [1, r]
    }

}