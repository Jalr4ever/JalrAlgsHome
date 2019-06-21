package leetcode.leetcode_CyC;

class Solution605 {
    // flowerbed = [1,0,0,0,1], n = 1
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int cnt = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int prev;
            int next;

            if (i == 0) {
                prev = 0;
            } else {
                prev = flowerbed[i - 1];
            }

            if (i == flowerbed.length - 1) {
                next = 0;
            } else {
                next = flowerbed[i + 1];
            }

            if (prev == 0 && next == 0 && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                cnt++;
                if (cnt >= n) {
                    return true;
                }
            }
        }

        return false;
    }
}